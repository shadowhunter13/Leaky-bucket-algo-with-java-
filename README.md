# Leaky Bucket and Token Bucket

This is a Java project of two algorithms: leaky bucket and token bucket. It is very simple.

**🌐 Live Demo:** Deploy your own version on [Replit](https://replit.com) (see [DEPLOY.md](DEPLOY.md))

## What is it?

Leaky bucket and token bucket are algorithms for rate limiting. Rate limiting means making sure packets don't go too fast.

- **Leaky Bucket:** Drains packets at constant rate (strict control)
- **Token Bucket:** Allows bursts when tokens available (flexible)

## How to run?

### Local Machine:
1. Open folder in VS Code
2. Go to `com/leakybucket/simulation/BucketSimulation.java` file
3. Click the **Run** button
4. See result in console

### Terminal:
```bash
cd /home/priyanshu/Documents/leakybucketalgo
javac -d . com/leakybucket/**/*.java
java -cp . com.leakybucket.simulation.BucketSimulation
```

### Live on Web (For Resume):
1. Go to [replit.com](https://replit.com)
2. Import from GitHub
3. Click Run
4. Share link with anyone!

See full deployment guide in [DEPLOY.md](DEPLOY.md)

## Files

- `LeakyBucket.java` - the leaky bucket code
- `TokenBucket.java` - the token bucket code  
- `BucketSimulation.java` - run this file
- `config.properties` - change settings here
- `LeakyBucketTest.java` - tests for the code
- `index.html` - web interface (future feature)

## Settings in config.properties

You can change this in config file:

- `bucket.capacity` = how big is bucket (default 10)
- `bucket.leakRate` = how fast it drains (default 2)
- `simulation.totalPackets` = how many packets to send (default 20)
- `simulation.arrivalPattern` = BURST or UNIFORM or RANDOM (default BURST)
- `algorithm.mode` = LEAKY or TOKEN (default LEAKY)

## For Your Resume

Add this to your resume:

```
🪣 Leaky Bucket Simulator
- Implemented rate-limiting algorithms in Java
- Configurable simulation with 3 traffic patterns
- Real-time statistics (drop rate, peak level)
- 18 JUnit test cases
Live Demo: [your-deployed-link]
```

## That's all!

Just run and see what happens :)
