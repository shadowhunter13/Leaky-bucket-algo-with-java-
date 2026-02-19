#!/bin/bash

# Quick launcher for Leaky Bucket Simulator

echo "🪣 Leaky Bucket Simulator - Web Version"
echo "========================================"
echo ""
echo "Starting web server..."
echo "Open your browser to: http://localhost:8080"
echo ""

cd "$(dirname "$0")"

# Check if running from JAR or source
if [ -f "leaky-bucket.jar" ]; then
    java -jar leaky-bucket.jar
else
    java -cp . com.leakybucket.simulation.BucketSimulation
fi
