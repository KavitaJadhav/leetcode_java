`TreeMap` is the right choice when you need **ordered keys** and operations like:

* Find the largest key ≤ x (`floorKey`)
* Find the smallest key ≥ x (`ceilingKey`)
* Get keys in sorted order
* Query ranges efficiently
* Maintain counts in sorted order
* Process events chronologically

For interviews, whenever you hear **timestamps**, **ranges**, **intervals**, **ordered events**, or **closest value**, think about `TreeMap`.

---

# 1. Time-Series / Timestamp Problems

| LC       | Problem                    | Why TreeMap?                                                    |
| -------- | -------------------------- | --------------------------------------------------------------- |
| **981**  | Time Based Key-Value Store | Binary search over timestamps (TreeMap is an alternative) ⭐⭐⭐⭐⭐ |
| **635**  | Design Log Storage System  | Retrieve logs in time range                                     |
| **1348** | Tweet Counts Per Frequency | Aggregate timestamps into intervals                             |
| **359**  | Logger Rate Limiter        | Ordered timestamps (optional)                                   |

---

# 2. Calendar / Interval Problems

| LC      | Problem         | Why TreeMap?                   |
| ------- | --------------- | ------------------------------ |
| **729** | My Calendar I   | Find previous/next booking     |
| **731** | My Calendar II  | Track overlaps                 |
| **732** | My Calendar III | Sweep line using TreeMap ⭐⭐⭐⭐⭐ |

Example:

```text
+1 at start
-1 at end

10  +1
20  -1
15  +1
25  -1
```

TreeMap automatically sorts these events.

---

# 3. Sweep Line Problems

TreeMap is perfect because events must be processed in sorted order.

| LC                                      | Problem |
| --------------------------------------- | ------- |
| **732** My Calendar III                 |         |
| **1094** Car Pooling (TreeMap solution) |         |
| **253** Meeting Rooms II (alternative)  |         |
| **218** The Skyline Problem             |         |

---

# 4. Ordered Frequency Problems

Need frequencies while maintaining sorted order.

| LC                                     | Problem |
| -------------------------------------- | ------- |
| **2034** Stock Price Fluctuation ⭐⭐⭐⭐⭐ |         |
| **480** Sliding Window Median          |         |
| **220** Contains Duplicate III         |         |
| **855** Exam Room                      |         |

Example:

```text
Price -> Frequency

100 -> 3

102 -> 1

105 -> 7
```

Need:

```java
firstKey()

lastKey()
```

---

# 5. Closest / Floor / Ceiling Queries

| LC                                                                    | Problem |
| --------------------------------------------------------------------- | ------- |
| **220** Contains Duplicate III                                        |         |
| **1847** Closest Room                                                 |         |
| **2070** Most Beautiful Item for Each Query                           |         |
| **2817** Minimum Absolute Difference Between Elements With Constraint |         |

Common operations:

```java
floorKey(x)

ceilingKey(x)
```

---

# 6. Ordered Map / Search Problems

| LC                                              | Problem |
| ----------------------------------------------- | ------- |
| **729** My Calendar                             |         |
| **981** TimeMap                                 |         |
| **715** Range Module ⭐⭐⭐⭐⭐                      |         |
| **352** Data Stream as Disjoint Intervals ⭐⭐⭐⭐⭐ |         |

---

# 7. Data Stream Problems

Need ordered insertion.

| LC                                                                 | Problem |
| ------------------------------------------------------------------ | ------- |
| **352** Data Stream as Disjoint Intervals                          |         |
| **295** Find Median from Data Stream *(TreeMap solution possible)* |         |
| **703** Kth Largest in Stream *(alternative)*                      |         |

---

# 8. Range Query Problems

TreeMap shines here.

| LC                                      | Problem |
| --------------------------------------- | ------- |
| **715** Range Module                    |         |
| **699** Falling Squares                 |         |
| **218** Skyline                         |         |
| **327** Count of Range Sum *(advanced)* |         |

---

# 9. Scheduling Problems

| LC                      | Problem |
| ----------------------- | ------- |
| **729** My Calendar     |         |
| **731** My Calendar II  |         |
| **732** My Calendar III |         |
| **1094** Car Pooling    |         |

---

# 10. Simulation Problems

| LC                                               | Problem |
| ------------------------------------------------ | ------- |
| **855** Exam Room                                |         |
| **1606** Find Servers That Handled Most Requests |         |
| **1845** Seat Reservation Manager                |         |

---

# Top 20 TreeMap Problems

These are the most valuable for interviews:

| LC         | Problem                                                      | Difficulty |
| ---------- | ------------------------------------------------------------ | ---------- |
| ⭐⭐⭐⭐⭐ 981  | Time Based Key-Value Store                                   | Medium     |
| ⭐⭐⭐⭐⭐ 729  | My Calendar I                                                | Medium     |
| ⭐⭐⭐⭐⭐ 731  | My Calendar II                                               | Medium     |
| ⭐⭐⭐⭐⭐ 732  | My Calendar III                                              | Hard       |
| ⭐⭐⭐⭐⭐ 352  | Data Stream as Disjoint Intervals                            | Hard       |
| ⭐⭐⭐⭐⭐ 715  | Range Module                                                 | Hard       |
| ⭐⭐⭐⭐⭐ 2034 | Stock Price Fluctuation                                      | Medium     |
| ⭐⭐⭐⭐ 220   | Contains Duplicate III                                       | Hard       |
| ⭐⭐⭐⭐ 635   | Design Log Storage System                                    | Medium     |
| ⭐⭐⭐⭐ 1348  | Tweet Counts Per Frequency                                   | Medium     |
| ⭐⭐⭐⭐ 1094  | Car Pooling                                                  | Medium     |
| ⭐⭐⭐⭐ 218   | Skyline Problem                                              | Hard       |
| ⭐⭐⭐⭐ 699   | Falling Squares                                              | Hard       |
| ⭐⭐⭐⭐ 855   | Exam Room                                                    | Medium     |
| ⭐⭐⭐ 480    | Sliding Window Median                                        | Hard       |
| ⭐⭐⭐ 295    | Find Median from Data Stream                                 | Hard       |
| ⭐⭐⭐ 1606   | Find Servers That Handled Most Requests                      | Hard       |
| ⭐⭐⭐ 1845   | Seat Reservation Manager                                     | Medium     |
| ⭐⭐⭐ 1847   | Closest Room                                                 | Hard       |
| ⭐⭐⭐ 2817   | Minimum Absolute Difference Between Elements With Constraint | Medium     |

---

# How to Recognize a TreeMap Problem

Look for these clues in the problem statement:

* ✅ "Find the closest value."
* ✅ "Find the previous/next event."
* ✅ "Maintain values in sorted order."
* ✅ "Process events by timestamp."
* ✅ "Support interval/range queries."
* ✅ "Need floor/ceiling operations."
* ✅ "Insert/delete while keeping order."
* ✅ "Merge or split intervals dynamically."

If you immediately think **"I need an ordered map rather than just a HashMap"**, `TreeMap` (or another balanced BST) is often the right tool. It gives you `O(log n)` insertion, deletion, lookup, and ordered navigation methods like `floorKey`, `ceilingKey`, `lowerKey`, `higherKey`, `firstKey`, and `lastKey`, which are difficult or impossible to achieve efficiently with a `HashMap`.
