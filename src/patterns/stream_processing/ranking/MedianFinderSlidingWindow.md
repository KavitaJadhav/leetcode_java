# Sliding Window Median — LeetCode 480

## Pattern

**Two Heaps + Lazy Deletion**

Use:

* `maxHeap` → lower half of current window
* `minHeap` → upper half
* `staleValue` → values removed from the window but still physically present in heaps

---

## Invariant

```text
maxHeap = lower half
minHeap = upper half

maxSize == minSize
OR
maxSize == minSize + 1
```

Therefore:

```text
Odd window:
median = maxHeap.peek()

Even window:
median = (maxHeap.peek() + minHeap.peek()) / 2.0
```

Use `long` before addition to avoid integer overflow:

```java
((long) maxHeap.peek() + minHeap.peek()) / 2.0
```

---

## Why Two Heaps?

A sliding window needs:

1. Insert a number
2. Remove a number
3. Find median

A normal sorted array would make insertion/removal expensive.

Two heaps give efficient access to the middle:

```text
             median
               ↓
     maxHeap | minHeap
    lower half | upper half
```

---

## Why Lazy Deletion?

Java `PriorityQueue` does not efficiently remove an arbitrary element.

Instead of doing:

```java
heap.remove(num);  // O(K)
```

mark the value as stale:

```java
staleValue.put(num, count + 1);
```

When that stale value reaches the top of a heap, physically remove it using `prune()`.

```java
private void prune(PriorityQueue<Integer> heap) {
    while (!heap.isEmpty()) {
        int value = heap.peek();

        if (!staleValue.containsKey(value))
            break;

        // Remove one stale occurrence
        ...
        heap.poll();
    }
}
```

---

## Logical Size vs Physical Size

This is VERY important.

```text
minSize / maxSize
    ↓
number of ACTIVE elements

minHeap.size() / maxHeap.size()
    ↓
ACTIVE + STALE elements
```

They can be different because of lazy deletion.

Therefore, maintain:

```java
int minSize;
int maxSize;
```

instead of relying on:

```java
minHeap.size();
maxHeap.size();
```

for balancing.

---

## Add

Before using `peek()` as the partition boundary:

```java
prune(maxHeap);
prune(minHeap);
```

Then:

```java
if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
    maxHeap.offer(num);
    maxSize++;
} else {
    minHeap.offer(num);
    minSize++;
}
```

Then rebalance.

---

## Remove

Steps:

```text
1. Prune stale values
2. Mark num as stale
3. Determine which logical half contains num
4. Decrease that logical size
5. Prune again
6. Rebalance
```

Important:

```java
if (!maxHeap.isEmpty() && num <= maxHeap.peek()) {
    maxSize--;
} else {
    minSize--;
}
```

---

## Rebalance

Upper half cannot contain more elements than lower half.

```java
if (maxSize > minSize + 1) {
    // move maxHeap → minHeap
}
else if (minSize > maxSize) {
    // move minHeap → maxHeap
}
```

Before polling an element to move, prune that heap so `poll()` does not return a stale/null value.

---

## Median

```java
prune(maxHeap);
prune(minHeap);
```

Then:

```java
if (maxSize == minSize) {
    return ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
}

return maxHeap.peek();
```

---

## Sliding Window

First build the complete window:

```java
for (int index = 0; index < k; index++) {
    addNum(nums[index]);
}

result[0] = median();
```

Then slide:

```java
for (int index = k; index < nums.length; index++) {

    remove(nums[index - k]);

    addNum(nums[index]);

    result[index - k + 1] = median();
}
```

Pattern:

```text
Build first window
       ↓
    median
       ↓
remove outgoing
       ↓
 add incoming
       ↓
    median
       ↓
    repeat
```

---

## Important Edge Cases

### 1. `k = 1`

Every element itself is the median.

```text
[1, 2, 3]
k = 1

[1.0, 2.0, 3.0]
```

### 2. Duplicate values

Example:

```text
[2, 2, 2, 2]
```

Lazy deletion must track **counts**, not just presence:

```java
Map<Integer, Integer>
```

### 3. Integer overflow

Do NOT do:

```java
(maxHeap.peek() + minHeap.peek()) / 2.0
```

because both are `int`.

Use:

```java
((long) maxHeap.peek() + minHeap.peek()) / 2.0
```

Example:

```text
2147483647 + 2147483647
```

would overflow an `int`.

### 4. Negative numbers

Two heaps naturally handle negative values.

### 5. Stale heap top

Always prune before relying on:

```java
heap.peek()
```

as the active boundary or median.

---

## Complexity

Let:

* `N` = number of elements
* `K` = window size

### Time

```text
addNum()  → O(log K)
remove()  → O(log K) amortized
median()  → O(log K) amortized
```

Overall:

**O(N log K) amortized**

### Space

```text
Heaps       → O(K)
staleValue  → O(K)
Output      → O(N)
```

Auxiliary:

**O(K)**

Including output:

**O(N + K)**

---

## Interview Explanation

> “I use two heaps to maintain the lower and upper halves of the sliding window. The max heap stores the lower half and the min heap stores the upper half, with the max heap allowed to have one extra element. Since Java's PriorityQueue doesn't efficiently remove arbitrary elements, I use lazy deletion: when an element leaves the window, I mark it stale in a frequency map and physically remove it when it reaches the top of its heap. Each element is inserted and physically removed at most once, giving O(N log K) amortized time and O(K) auxiliary space.”

## Key Things to Remember

```text
Two heaps
    ↓
maxHeap = lower half
minHeap = upper half

Lazy deletion
    ↓
staleValue map

Logical sizes
    ↓
maxSize / minSize

Odd
    ↓
maxHeap.peek()

Even
    ↓
average of both peeks

Overflow
    ↓
cast to long BEFORE addition

Overall
    ↓
O(N log K) amortized
```
