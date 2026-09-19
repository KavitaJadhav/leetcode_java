Here are clean **Markdown notes on Rate Limiting** (Karat + system design interview ready).

---

# 🚦 Rate Limiting — Interview Notes

---

# 🧠 What is Rate Limiting?

Rate limiting controls how many requests a user/service can make in a given time window.

### Goal:

* Protect system from overload
* Ensure fair usage
* Prevent abuse (DDoS, spam)

---

# 📌 Why it is needed

* Prevent API abuse
* Maintain system stability
* Ensure fair usage across users
* Protect downstream services

---

# ⚙️ Core Rate Limiting Algorithms

---

## 1. Fixed Window Counter

### Idea:

Divide time into fixed blocks.

```text
0–10 sec → window 1
10–20 sec → window 2
```

### Example:

```text
limit = 5 requests per 10 sec
```

### Problem:

* burst at boundary (10 + 10 requests quickly)

---

## 2. Sliding Window Log

### Idea:

Store timestamps of requests.

### Data structure:

```java
Deque<Long>
```

### Logic:

* remove old timestamps
* check current window size

### Pros:

* accurate

### Cons:

* high memory usage

---

## 3. Sliding Window Counter

### Idea:

Approximate logs using buckets.

```text
bucket = 1 sec / 1 min
```

### Pros:

* efficient
* scalable

### Cons:

* approximation error

---

## 4. Token Bucket

### Idea:

Tokens are added over time.

* Each request consumes 1 token
* Tokens refill at fixed rate
* Supports bursts

### Formula:

```text
tokens = min(capacity, tokens + refillRate * time)
```

### Data:

```java
capacity
tokens
refillRate
lastRefillTime
```

### Pros:

* allows burst traffic
* simple
* widely used

### Cons:

* slightly complex logic

---

## 5. Leaky Bucket

### Idea:

Requests are processed at fixed rate.

* Queue acts like bucket
* Output is smooth

### Pros:

* stable output rate

### Cons:

* no burst support

---

# ⚖️ Comparison

| Algorithm              | Burst Support | Accuracy | Memory | Use Case        |
| ---------------------- | ------------- | -------- | ------ | --------------- |
| Fixed Window           | ❌             | Medium   | Low    | simple APIs     |
| Sliding Window Log     | ❌             | High     | High   | strict limits   |
| Sliding Window Counter | ⚠️            | Medium   | Low    | scalable APIs   |
| Token Bucket           | ✅             | High     | Low    | real systems    |
| Leaky Bucket           | ❌             | High     | Low    | traffic shaping |

---

# 🧱 Data Structures Used

| Scenario         | Structure     |
| ---------------- | ------------- |
| Ordered stream   | Deque         |
| Unordered stream | TreeMap       |
| High scale       | Redis / Kafka |
| Approximation    | Buckets       |

---

# 🌐 Distributed Rate Limiting

---

## Problem:

Single machine limiter fails in multi-server systems.

---

## Solutions:

### 1. Central store

* Redis

### 2. Event streaming

* Kafka

### 3. API gateway layer

* Kong / Nginx

---

## Redis-based approach

* key = userId
* value = counter / token state
* TTL for cleanup

---

## Atomic updates using Lua

Prevents race conditions:

```text
GET → check → SET ❌ not safe
Lua script → atomic ✅
```

---

# 🧠 Token Bucket (Core Idea)

```text
capacity = max tokens
refillRate = tokens/sec
```

### Behavior:

* Requests consume tokens
* Tokens refill over time
* Allows burst traffic

---

# 🧪 Common Interview Questions

## 1. Sliding Window vs Token Bucket?

* Sliding window = strict limit
* Token bucket = burst-friendly

---

## 2. What if requests are out of order?

Use:

```text
TreeMap or sorted structure
```

---

## 3. How to scale?

* Redis cluster
* Kafka stream processing
* Sharded by userId

---

## 4. How to ensure correctness in distributed systems?

* Lua scripts in Redis
* atomic counters
* single source of truth

---

## 5. How to handle spikes?

* token bucket absorbs burst
* sliding window rejects early

---

# 🚀 Real-world systems

* API gateways
* Login throttling
* Payment systems
* Microservices protection

Examples:

* Redis
* Nginx
* Kong Gateway

---

# 💬 Interview Summary (say this)

> “Rate limiting controls request flow using algorithms like fixed window, sliding window, token bucket, and leaky bucket. In distributed systems, we use Redis with atomic Lua scripts to ensure consistency across nodes.”

---

If you want, I can next convert this into:

* 📄 1-page printable cheat sheet
* 🧠 flashcards for revision
* 🔥 Karat mock interview questions set (very high value)

Just tell 👍
