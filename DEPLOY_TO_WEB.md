# 🚀 Deploy to Web - Step by Step

Your project is ready to go live! Here are **3 easy ways** to make it accessible from any browser:

---

## **Method 1: Replit (EASIEST - 2 minutes) ⭐**

### Steps:

1. **Go to** https://replit.com and sign up (free)

2. **Click "Create"** → **"Import from GitHub"**

3. **Paste this URL:**
   ```
   https://github.com/shadowhunter13/Leaky-bucket-algo-with-java-
   ```

4. **Click "Import"**

5. **Wait for files to load** (30 seconds)

6. **Click "Run" button** ▶ (top right)

7. **Done! You get a live URL instantly:** 
   ```
   https://replit.com/@yourname/leaky-bucket-algo
   ```

### Share:
- Anyone can visit your URL
- They can run the simulation without installing anything
- Perfect for portfolio/resume

**Add to resume:**
```
Live Demo: https://replit.com/@yourname/leaky-bucket-algo
```

---

## **Method 2: Use Runnable JAR (Desktop App)**

Already created! 

### Run locally:
```bash
cd /home/priyanshu/Documents/leakybucketalgo
java -jar leaky-bucket.jar
```

### Share the JAR:
```bash
# Copy file
cp leaky-bucket.jar ~/Desktop/

# Send to anyone - they run with:
java -jar leaky-bucket.jar
```

---

## **Method 3: Deploy on Railway (Free Hosting)**

### Steps:

1. **Go to** https://railway.app

2. **Sign up with GitHub** (free)

3. **Click "New Project"** → **"Deploy from GitHub repo"**

4. **Select your repo:**
   ```
   shadowhunter13/Leaky-bucket-algo-with-java-
   ```

5. **Wait for auto-deploy** (2-3 minutes)

6. **Get live URL:** e.g., `https://your-app-abc123.up.railway.app`

7. **Anyone can run from browser**

### Add to Resume:
```
Live Demo: https://your-app-abc123.up.railway.app
```

---

## **Method 4: Docker Container (Advanced)**

Create `Dockerfile`:

```dockerfile
FROM openjdk:21
WORKDIR /app
COPY leaky-bucket.jar .
CMD ["java", "-jar", "leaky-bucket.jar"]
```

Build & run:
```bash
docker build -t leaky-bucket .
docker run leaky-bucket
```

Deploy to Docker Hub or cloud platform.

---

## **Quick Comparison**

| Method | Time | Difficulty | Best For | Cost |
|--------|------|-----------|----------|------|
| **Replit** | 2 min | Very Easy | Portfolio/Demo | Free |
| **JAR** | 1 min | Super Easy | Share File | Free |
| **Railway** | 5 min | Easy | Production | Free tier |
| **Docker** | 10 min | Medium | DevOps | Varies |

---

## **My Recommendation: Use Replit! 🏆**

✅ Fastest (2 minutes)  
✅ No setup needed  
✅ Anyone can run from browser  
✅ Perfect for resume/portfolio  
✅ Free forever

---

## **After Deployment: Update Resume**

Add this section:

```markdown
## PROJECTS

### 🪣 Leaky Bucket Rate-Limiting Simulator
**Live Demo:** https://replit.com/@yourname/leaky-bucket-algo  
**GitHub:** https://github.com/shadowhunter13/Leaky-bucket-algo-with-java-

- Implemented leaky bucket and token bucket algorithms in Java
- Interactive web demo with real-time packet processing
- Configurable arrival patterns: BURST, UNIFORM, RANDOM
- Statistics tracking: drop rate, peak level, average utilization
- 18+ JUnit test cases with comprehensive coverage
- Technologies: Java, Algorithms, Object-Oriented Design
```

---

## **Terminal Commands**

```bash
# Run JAR
java -jar leaky-bucket.jar

# Check what's in JAR
jar tf leaky-bucket.jar

# Extract JAR if needed
jar xf leaky-bucket.jar

# Create new JAR (if you update code)
javac -d . com/leakybucket/**/*.java
jar cfm leaky-bucket.jar META-INF/MANIFEST.MF com/ config.properties
```

---

## **Next Steps:**

1. ✅ Go to https://replit.com
2. ✅ Import from GitHub (your repo URL)
3. ✅ Click Run
4. ✅ Get live URL
5. ✅ Add to resume
6. ✅ Done! 🎉

---

**Want help with any step?** Let me know! 🚀
