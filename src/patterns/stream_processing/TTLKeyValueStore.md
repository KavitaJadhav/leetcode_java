Here’s a clean **Karat-style TTL Key-Value Store problem statement** (very common in interviews for caching + system design + data structures).

---

# 🧩 Problem: TTL Key-Value Store

Design a key-value store that supports **time-based expiration (TTL)** for each key.

Each key can have an optional expiration time after which it should no longer be accessible.

---

# 📌 Requirements

You need to implement a data structure with the following operations:

---

## 1. `put(key, value, ttl, currentTime)`

Store a key-value pair with a time-to-live (TTL).

* `ttl` is in seconds (or milliseconds depending on assumption)
* Key expires at:

  ```text id="p1"
  expiryTime = currentTime + ttl
  ```

---

## 2. `get(key, currentTime)`

Return the value if:

* key exists
* key is not expired

Otherwise return `null` / `-1`.

---

## 3. `remove(key)`

Delete the key immediately.

---

## 4. (Optional extension)

* `countUnexpiredKeys(currentTime)`
* `cleanupExpiredKeys(currentTime)`

---

# 🧠 Example

```text id="e1"
put("A", 10, ttl=5, time=100)

get("A", 102) → 10   (valid)
get("A", 106) → null  (expired)
```

---

# 📌 Behavior Rules

### 1. Expiry is time-based

A key is invalid if:

```text id="r1"
currentTime >= expiryTime
```

---

### 2. Lazy vs eager cleanup

You can:

* remove expired keys during `get`
* or run background cleanup

---

# ⚙️ API Design

```java id="api1"
class TTLKeyValueStore {

    public void put(String key, int value, int ttl, long currentTime) {}

    public Integer get(String key, long currentTime) {}

    public void remove(String key) {}
}
```

---

# 🧠 Expected Data Structures

## Basic solution:

```text id="d1"
HashMap<Key, Value>
HashMap<Key, ExpiryTime>
```

---

## Better solution (scalable):

```text id="d2"
HashMap<Key, Value>
HashMap<Key, ExpiryTime>
MinHeap (expiry ordering)
```

---

# 🚨 Key Edge Cases

* Key overwritten with new TTL
* Expired key accessed
* Multiple updates to same key
* Cleanup not triggered until access

---

# ⚡ Variations Interviewers Ask

## 1. How would you support millions of keys?

→ Use heap + periodic cleanup thread

---

## 2. How would you make it thread-safe?

→ synchronize / locks / concurrent maps

---

## 3. How would you scale it across servers?

→ distributed cache like Redis

---

## 4. What if TTL changes frequently?

→ update expiry in heap (lazy deletion)

---

# 🧠 Core Concept

> TTL store = HashMap + time tracking + expiration strategy

---

# 🚀 One-line intuition

👉 “A TTL key-value store is a hash map where every key has an expiry timestamp and is considered invalid after that time.”

---

If you want next, I can give:

* 🔥 full Java implementation (heap + hashmap version)
* 🔥 follow-up questions Karat will ask
* 🔥 comparison: TTL store vs Redis expiration model

Just tell 👍
