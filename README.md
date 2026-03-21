# DSA Patterns in Java 💻

A structured collection of Data Structures and Algorithms problems organized by patterns for efficient problem-solving and interview preparation.

---

## 📌 Summary

This repository focuses on solving algorithmic problems using reusable patterns instead of memorizing individual solutions. It is designed for coding interview preparation (Google, Waymo, etc.).

---

## 🧠 Key Topics

* Arrays & Strings
* Sliding Window
* Two Pointers
* Binary Search
* Recursion & Backtracking
* Graphs (BFS/DFS)
* Dynamic Programming

---

## 📂 Repository Structure

```id="dsastr1"
Arrays/
SlidingWindow/
TwoPointers/
BinarySearch/
Graphs/
dynamic_programming/
```

Each folder contains:

* Problem statement
* Approach / intuition
* Time & space complexity
* Clean Java implementation

---

## 🚀 Example

### Maximum Subarray (Kadane’s Algorithm)

```java id="dsaex1"
public int maxSubArray(int[] nums) {
    int max = nums[0], sum = 0;
    for (int n : nums) {
        sum = Math.max(n, sum + n);
        max = Math.max(max, sum);
    }
    return max;
}
```

---

## 🎯 Goals

* Build strong problem-solving skills
* Master common DSA patterns
* Improve interview readiness

---

## 📈 Progress

* Problems solved: 90+
* Continuously updated

---

## 💡 Key Insight

Focus on recognizing patterns → not memorizing solutions.

---

## 🔗 References

* LeetCode
* NeetCode

---
