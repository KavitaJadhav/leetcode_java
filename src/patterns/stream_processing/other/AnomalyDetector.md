A good **Karat-style problem statement** for the `AnomalyDetector` (spike detection) question would be:

---

## Problem: Detect Anomalous Traffic Spikes

You are given a stream of events from multiple services. Each event contains:

* `serviceId` (String)
* `timestamp` (long, in seconds)

Implement an `AnomalyDetector` class that detects whether a service is experiencing an unusual spike in traffic.

A service is considered anomalous if it receives **more than `threshold` events within a rolling window of `windowSize` seconds**.

### API

```java
class AnomalyDetector {

    public AnomalyDetector(int windowSize, int threshold) {
    }

    public boolean processEvent(String serviceId, long timestamp) {
    }
}
```

### Behavior

For each incoming event:

1. Add the event to the service's history.
2. Consider only events that occurred within the last `windowSize` seconds (inclusive).
3. Return:

    * `true` if the number of events in the current window exceeds `threshold`
    * `false` otherwise

---

## Example

```java
AnomalyDetector detector = new AnomalyDetector(10, 3);
```

Meaning:

* Window size = 10 seconds
* Threshold = 3 events

### Input

```java
processEvent("A", 100); // false
processEvent("A", 101); // false
processEvent("A", 102); // false
processEvent("A", 103); // true
```

### Explanation

At timestamp `103`, service `A` has received:

```text
100, 101, 102, 103
```

That's 4 events within the last 10 seconds, which exceeds the threshold of 3.

---

## Example 2

```java
AnomalyDetector detector = new AnomalyDetector(5, 2);

processEvent("A", 100); // false
processEvent("A", 101); // false
processEvent("A", 107); // false
```

### Explanation

At timestamp `107`, the event at `100` and `101` are outside the 5-second window:

```text
Current window: [102, 107]
Events present: 107
Count = 1
```

No anomaly is detected.

---

## Constraints

* Events arrive in chronological order.
* `serviceId` is a non-empty string.
* `1 <= threshold <= 10^5`
* Up to millions of events may be processed.
* Aim for efficient processing per event.

---

## Follow-up Questions

1. How would you detect anomalies across all services combined?
2. How would you support events arriving out of order?
3. How would you scale this across multiple servers?
4. How would you detect spikes relative to a moving average instead of a fixed threshold?

---

### Expected Approach

Use:

```java
Map<String, Deque<Long>>
```

where each service maintains a queue of timestamps. For each event:

* Add the new timestamp
* Remove timestamps older than the window
* Check the queue size against the threshold

This yields **O(1) amortized time per event** and **O(number of events in the window)** space.

-----------------------

Here’s a **clean summary of the Karat-style anomaly detection question + all follow-up answers**.

---

# 🧩 Problem Summary

You are given a stream of events:

```text
(service, timestamp)
```

You must detect anomalies when:

> Number of events in a time window > threshold

---

# 🧠 Core Solutions

## 1. Ordered events (most common case)

### ✅ Use:

```java
Map<String, Deque<Integer>>
```

### Logic:

* Add event
* Remove old events from front
* Check size

```java
events.addLast(time);

while (events.peekFirst() < time - window)
    events.pollFirst();

return events.size() > threshold;
```

---

## 2. Out-of-order events

### ✅ Use:

```java
Map<String, TreeMap<Integer, Integer>>
```

### Logic:

* Store timestamps in sorted order
* Use range query
* Sum frequencies

```java
NavigableMap sub = events.subMap(start, true, time, true);

int count = sum(sub.values());
return count > threshold;
```

---

## 3. Global anomaly across all services

### Options:

* Single global deque (ordered)
* Or global TreeMap

```java
globalQueue.add(time);
cleanup();
check size;
```

---

## 4. Scaling across servers

### Best approaches:

* **Kafka partitioning (best)**

   * Partition by service
   * Preserves ordering per service

* **Redis (ZSET)**

   * score = timestamp
   * supports range queries

* **Distributed aggregation**

   * per-node counters → merge later

---

## 5. Spike detection using moving average

### Instead of fixed threshold:

```text
current > average * multiplier
```

### Maintain:

* sliding window
* sum of values

```java
avg = sum / windowSize;

if (current > 2 * avg)
    anomaly
```

---

# ⚖️ Data structure cheat sheet

| Case                | Best structure  |
| ------------------- | --------------- |
| Ordered stream      | Deque           |
| Out-of-order stream | TreeMap         |
| Top-K               | Heap            |
| Global aggregation  | Deque / TreeMap |
| Large scale system  | Kafka / Redis   |

---

# 🎯 Key Interview Insight

What interviewers are testing:

* Can you pick correct data structure?
* Do you understand ordering assumptions?
* Can you adapt when constraints change?
* Do you know how to scale a local solution?

---

If you want, I can turn this into a **1-page Karat cheat sheet PDF style** or give you **mock interview questions based on this pattern**.

