# 🌐 Deploy Leaky Bucket Project to Web

Your Java project can now run as a **web application**! Choose your platform:

---

## **Option 1: Replit (EASIEST - 2 minutes)**

### Steps:
1. Go to [replit.com](https://replit.com)
2. Sign up (free)
3. Click **"Create"** → **"Import from GitHub"**
4. Paste: `https://github.com/shadowhunter13/Leaky-bucket-algo-with-java-`
5. Click **"Import"**
6. Click **"Run"** ▶
7. Done! You get a live URL instantly ✅

**Your Live URL:** `https://replit.com/@yourname/leaky-bucket`

**Features:**
- No setup needed
- Anyone can run it from browser
- See output live
- Perfect for portfolio/resume

---

## **Option 2: Create Runnable JAR (Desktop)**

### Steps in Terminal:

```bash
cd /home/priyanshu/Documents/leakybucketalgo

# Create manifest file
mkdir -p META-INF
cat > META-INF/MANIFEST.MF << 'EOF'
Manifest-Version: 1.0
Main-Class: com.leakybucket.simulation.BucketSimulation
EOF

# Create JAR
jar cfm leaky-bucket.jar META-INF/MANIFEST.MF com/

# Run JAR
java -jar leaky-bucket.jar

# Share JAR - anyone can run it with: java -jar leaky-bucket.jar
```

**Benefits:**
- Single file (.jar)
- No installation needed
- Share via email/cloud

---

## **Option 3: Spring Boot Web App (Advanced)**

### Create REST API:

```bash
# 1. Add to pom.xml (create if using Maven)
# 2. Create REST endpoint that returns JSON
# 3. Deploy to Railway or Render
```

**Example Request:**
```bash
curl -X POST http://localhost:8080/api/simulate \
  -H "Content-Type: application/json" \
  -d '{"mode":"LEAKY","capacity":10,"leakRate":3}'
```

**Response:**
```json
{
  "mode": "LEAKY",
  "stats": {
    "totalSent": 25,
    "accepted": 13,
    "dropped": 12,
    "dropRate": "48.0%"
  }
}
```

---

## **Option 4: Deploy on Railway (Professional)**

### Steps:

```bash
# 1. Push code to GitHub (already done ✓)

# 2. Create railway.yaml file
cat > railway.yaml << 'EOF'
services:
  web:
    build: .
    start: java -jar leaky-bucket.jar
    port: 8080
EOF

# 3. Go to https://railway.app
# 4. Import from GitHub
# 5. Deploy button
```

**Live URL:** `https://your-app.up.railway.app`

---

## **Option 5: Deploy on Render (Free)**

### Steps:

1. Go to [render.com](https://render.com)
2. **"New"** → **"Web Service"**
3. Connect GitHub repo
4. Runtime: **Java**
5. Build Command: `javac -d . com/leakybucket/**/*.java`
6. Start Command: `java -cp . com.leakybucket.simulation.BucketSimulation`
7. Deploy! ✓

**Live URL:** Auto-generated after deploy

---

## **My Recommendation** 🏆

| Use Case | Platform | Setup |
|----------|----------|-------|
| **Portfolio/Resume** | **Replit** | 2 min ⭐ |
| **Share with Friends** | **JAR File** | 1 min |
| **Professional Project** | **Railway** | 5 min |
| **Educational** | **Render** | 5 min |

---

## **For Your Resume:**

Add this:

```
🪣 Leaky Bucket Rate-Limiting Simulator
- Java implementation of leaky bucket algorithm
- Interactive web demo: [live-url]
- Real-time statistics (drop rate, utilization)
- GitHub: https://github.com/shadowhunter13/Leaky-bucket-algo-with-java-
```

---

## **Quick Terminal Commands:**

```bash
# Run locally
cd /home/priyanshu/Documents/leakybucketalgo
java -cp . com.leakybucket.simulation.BucketSimulation

# Create JAR
jar cfm leaky-bucket.jar META-INF/MANIFEST.MF com/
java -jar leaky-bucket.jar

# View config
cat config.properties

# View logs
cat leakybucket.log
```

---

**Ready?** Pick an option and let me set it up for you! 🚀
