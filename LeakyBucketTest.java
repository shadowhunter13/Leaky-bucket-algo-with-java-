package com.leakybucket;

import com.leakybucket.core.LeakyBucket;
import com.leakybucket.exceptions.BucketOverflowException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

// Unit tests for LeakyBucket
@DisplayName("LeakyBucket Tests")
class LeakyBucketTest {

    private LeakyBucket bucket;

    // Initialize bucket before each test
    @BeforeEach
    void setUp() {
        bucket = new LeakyBucket(5, 2);
    }


    @Test
    @DisplayName("Bucket starts empty")
    void testInitiallyEmpty() {
        assertEquals(0, bucket.getCurrentLevel());
        assertTrue(bucket.isEmpty());
        assertFalse(bucket.isFull());
    }

    @Test
    @DisplayName("Invalid arguments throw IllegalArgumentException")
    void testInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> new LeakyBucket(0, 2));
        assertThrows(IllegalArgumentException.class, () -> new LeakyBucket(5, -1));
    }


    @Test
    @DisplayName("Single packet is accepted")
    void testSinglePacketAccepted() throws BucketOverflowException {
        bucket.addPacket(1);
        assertEquals(1, bucket.getCurrentLevel());
    }

    @Test
    @DisplayName("Fill bucket to capacity — all accepted")
    void testFillToCapacity() throws BucketOverflowException {
        for (int i = 0; i < 5; i++) {
            bucket.addPacket(1);
        }
        assertEquals(5, bucket.getCurrentLevel());
        assertTrue(bucket.isFull());
    }

    @Test
    @DisplayName("Overflow throws BucketOverflowException")
    void testOverflowThrowsException() throws BucketOverflowException {
        for (int i = 0; i < 5; i++) bucket.addPacket(1);

        BucketOverflowException ex = assertThrows(
            BucketOverflowException.class,
            () -> bucket.addPacket(1)
        );

        assertEquals(1, ex.getPacketSize());
        assertEquals(5, ex.getCurrentLevel());
        assertEquals(5, ex.getCapacity());
    }

    @Test
    @DisplayName("Exception message includes overflow details")
    void testExceptionMessage() throws BucketOverflowException {
        for (int i = 0; i < 5; i++) bucket.addPacket(1);

        Exception ex = assertThrows(BucketOverflowException.class, () -> bucket.addPacket(2));
        assertTrue(ex.getMessage().contains("overflow"));
    }

    @Test
    @DisplayName("Large packet that alone exceeds capacity is dropped")
    void testOversizedPacketDropped() {
        assertThrows(BucketOverflowException.class, () -> bucket.addPacket(6));
        assertEquals(0, bucket.getCurrentLevel()); // bucket unchanged
    }

    @Test
    @DisplayName("Packet of size 3 occupies 3 slots")
    void testVariablePacketSize() throws BucketOverflowException {
        bucket.addPacket(3);
        assertEquals(3, bucket.getCurrentLevel());
    }

    @Test
    @DisplayName("Partial fill then overflow with large packet")
    void testPartialThenOverflow() throws BucketOverflowException {
        bucket.addPacket(3); // level = 3
        assertThrows(BucketOverflowException.class, () -> bucket.addPacket(3)); // needs 3, only 2 free
        assertEquals(3, bucket.getCurrentLevel()); // unchanged after drop
    }


    @Test
    @DisplayName("Bucket level does not go below zero after excessive leak")
    void testLeakDoesNotGoBelowZero() throws BucketOverflowException {
        bucket.addPacket(2);
        // Force leak by simulating time (we just call leak multiple times)
        for (int i = 0; i < 10; i++) bucket.leak();
        assertTrue(bucket.getCurrentLevel() >= 0);
    }

    @Test
    @DisplayName("After waiting, previously full bucket accepts new packets")
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    void testRecoveryAfterWait() throws BucketOverflowException, InterruptedException {
        for (int i = 0; i < 5; i++) bucket.addPacket(1);
        assertTrue(bucket.isFull());

        Thread.sleep(2500);

        // Should now accept a new packet without throwing
        assertDoesNotThrow(() -> bucket.addPacket(1));
    }


    @Test
    @DisplayName("isEmpty returns true only when level is 0")
    void testIsEmpty() throws BucketOverflowException {
        assertTrue(bucket.isEmpty());
        bucket.addPacket(1);
        assertFalse(bucket.isEmpty());
    }

    @Test
    @DisplayName("isFull returns true only at capacity")
    void testIsFull() throws BucketOverflowException {
        assertFalse(bucket.isFull());
        for (int i = 0; i < 5; i++) bucket.addPacket(1);
        assertTrue(bucket.isFull());
    }

    @Test
    @DisplayName("toString contains capacity and leakRate")
    void testToString() {
        String s = bucket.toString();
        assertTrue(s.contains("5"));
        assertTrue(s.contains("2"));
    }

    @Test
    @DisplayName("Getters return correct configured values")
    void testGetters() {
        assertEquals(5, bucket.getBucketCapacity());
        assertEquals(2, bucket.getLeakRate());
    }


    @Test
    @DisplayName("BucketOverflowException fields are accurate")
    void testExceptionFields() throws BucketOverflowException {
        bucket.addPacket(4); // level = 4
        BucketOverflowException ex = assertThrows(
            BucketOverflowException.class,
            () -> bucket.addPacket(3)  // 4+3=7 > 5
        );
        assertEquals(3, ex.getPacketSize());
        assertEquals(4, ex.getCurrentLevel());
        assertEquals(5, ex.getCapacity());
        assertEquals(2, ex.getOverflowAmount()); // (4+3)-5 = 2
    }
}
