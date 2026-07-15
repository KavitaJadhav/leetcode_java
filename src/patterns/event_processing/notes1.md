These are excellent examples of **"real-world coding interview"** problems. They don't fall under classic patterns like DFS or DP. Instead, they belong to **stream processing**, **sliding windows**, **event aggregation**, and **time-series data structures**.

Here's how I would classify them.

---

# Pattern 1: Sliding Time Window / Event Stream Processing

### Example

> Find the average of all events received in the last 60 minutes.

```
Time ---->

1 2 3 4 5 6 7 8 ...

Current time = 8

Window:
[3.........8]
```

Every new event:

* add new event
* remove expired events
* update sum

Typical data structure:

```
Queue

(timestamp,value)

[(10,5)]
[(12,7)]
[(15,3)]
```

Maintain:

```
sum
count
```

Complexity

```
Insert : O(1)
Delete : O(1)
Average: O(1)
```

### Interview topics

* Queue
* Sliding Window
* Time-based eviction
* Stream processing

### Similar LeetCode

* **346** Moving Average from Data Stream ⭐⭐⭐⭐⭐
* **362** Design Hit Counter ⭐⭐⭐⭐⭐
* **933** Number of Recent Calls ⭐⭐⭐⭐⭐
* **359** Logger Rate Limiter
* **1348** Tweet Counts Per Frequency

---

# Pattern 2: Event Aggregation / Group By

Example:

> Generate invoice for every car passing toll booths.

Input

```
Car A

10:01
10:12
10:40

Car B

11:15
11:30
```

Need

```
Car A

3 trips

Total = ₹300


Car B

2 trips

Total = ₹200
```

Data structure

```
HashMap

carId

↓

Invoice
```

Or

```
HashMap

carId

↓

List<Trips>
```

Topics

* HashMap
* Aggregation
* Group By
* Batch Processing

Real systems

* Billing
* Analytics
* Spark
* Kafka Streams
* Flink

### Similar LeetCode

No exact billing problem exists, but these are conceptually close:

* **1396** Design Underground System ⭐⭐⭐⭐⭐
* **1604** Alert Using Same Key-Card Three or More Times
* **1348** Tweet Counts Per Frequency
* **635** Design Log Storage System

---

# Pattern 3: Fixed Size Sliding Window

Example

> Average of recent 10 events.

Window

```
[5]

↓

[5,2]

↓

[5,2,8]

↓

...

↓

Last 10 only
```

Need

```
Queue

+

Running Sum
```

Very common.

LeetCode

* **346** Moving Average from Data Stream ⭐⭐⭐⭐⭐
* **239** Sliding Window Maximum
* **643** Maximum Average Subarray I
* **480** Sliding Window Median

---

# Pattern 4: Out-of-Order Stream Processing

Your third problem has an extra challenge:

> events arrive in no order

Example

```
Receive

10:20

then

10:05

then

10:12
```

Now queue alone won't work.

Need

```
TreeMap

or

PriorityQueue

or

Balanced BST
```

Topics

* Event-time processing
* Watermarks (streaming systems)
* Ordered map

Real-world

* Kafka Streams
* Flink
* Spark Streaming

LeetCode examples

There isn't a perfect match, but similar ideas appear in:

* **981** Time Based Key-Value Store
* **729** My Calendar I
* **731** My Calendar II
* **732** My Calendar III

---

# Pattern 5: Time-Series Data Structures

These questions store values indexed by time.

Examples

```
set(key,value,time)

get(key,time)
```

Need

```
HashMap

↓

Sorted timestamps

↓

Binary Search
```

LeetCode

* **981** Time Based Key Value Store ⭐⭐⭐⭐⭐
* **635** Design Log Storage System
* **1348** Tweet Counts Per Frequency

---

# Pattern 6: Online Algorithms

Very Google-ish.

You cannot read all data first.

Need answer

```
while receiving data
```

instead of

```
after reading everything
```

Examples

* running average
* top K
* median
* moving average

LeetCode

* **295** Find Median from Data Stream ⭐⭐⭐⭐⭐
* **703** Kth Largest Element in a Stream
* **346** Moving Average from Data Stream

---

# Pattern 7: Rate Limiting / Window Counting

Count events within a time window.

```
last 60 sec

last 5 min

last hour
```

LeetCode

* **362** Design Hit Counter
* **933** Number of Recent Calls
* **359** Logger Rate Limiter

---

# Pattern 8: Interval / Timeline Processing

If events have start/end times instead of single timestamps.

Examples

```
Car entered

10:01

Exited

10:35
```

Need duration

or

maximum concurrent cars

LeetCode

* **253** Meeting Rooms II
* **732** My Calendar III
* **1094** Car Pooling

---

# Common Interview Pattern Names

| Pattern                                     | Common Data Structures | Representative LeetCode |
| ------------------------------------------- | ---------------------- | ----------------------- |
| Sliding Time Window                         | Queue, Deque           | 346, 362, 933           |
| Fixed-Size Sliding Window                   | Queue                  | 346, 239, 643           |
| Event Aggregation                           | HashMap                | 1396, 1348              |
| Stream Processing                           | Queue, Heap            | 295, 703                |
| Time-Series Storage                         | TreeMap, Binary Search | 981, 635                |
| Online Algorithms                           | Heap, Queue            | 295, 703                |
| Event-Time Processing (Out-of-Order Events) | TreeMap, PriorityQueue | 981, 729, 731, 732      |
| Rate Limiting                               | Queue, HashMap         | 359, 362, 933           |
| Interval Scheduling / Timeline              | Heap, Sorting          | 253, 732, 1094          |

### For backend interviews at companies like Google, Uber, Stripe, Airbnb, Datadog, or Snowflake, I'd especially recommend mastering these problems:

* **295** – Find Median from Data Stream
* **346** – Moving Average from Data Stream
* **359** – Logger Rate Limiter
* **362** – Design Hit Counter
* **703** – Kth Largest Element in a Stream
* **933** – Number of Recent Calls
* **981** – Time Based Key-Value Store
* **1348** – Tweet Counts Per Frequency
* **1396** – Design Underground System
* **729 / 731 / 732** – My Calendar I, II, III

These cover most of the core ideas behind streaming, time-window, and event-processing questions that frequently appear in senior backend engineering interviews.
