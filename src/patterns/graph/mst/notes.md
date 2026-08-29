Yes — **the underlying pattern is common in interviews**, but this **exact problem formulation is less common**.

### What interviewers are really testing

This problem combines:

* **Minimum Spanning Tree (MST)**
* **Kruskal / Prim**
* **DSU (Union-Find)**
* Recognizing a graph hidden inside a grid
* Handling potentially large input efficiently

The important recognition is:

> "Connect all cities with minimum total repair cost" → **MST**

### How common?

I'd rank it:

| Concept                                                | Interview frequency |
| ------------------------------------------------------ | ------------------- |
| BFS / DFS on grid                                      | ⭐⭐⭐⭐⭐               |
| Basic MST                                              | ⭐⭐⭐⭐                |
| Kruskal + DSU                                          | ⭐⭐⭐⭐                |
| Prim's algorithm                                       | ⭐⭐⭐⭐                |
| This exact grid-road formulation                       | ⭐⭐                  |
| Optimizing this problem without constructing all edges | ⭐⭐⭐                 |

For **Google / Meta / Amazon / Microsoft-level interviews**, you should definitely know MST and be comfortable identifying when a problem is secretly an MST.

### Similar problems worth practicing

If you're preparing systematically, I'd prioritize:

1. **Min Cost to Connect All Points** — LeetCode 1584
   Very similar MST recognition.

2. **Connecting Cities With Minimum Cost** — LeetCode 1135
   Almost directly tests MST.

3. **Optimize Water Distribution in a Village** — LeetCode 1168
   Excellent Kruskal/DSU problem.

4. **Number of Operations to Make Network Connected** — LeetCode 1319
   DSU/connectivity rather than MST, but very relevant.

5. **Min Cost to Connect All Points** is especially important because it looks like a coordinate/geometric problem but is fundamentally **MST**.

For your current preparation, I'd make sure you can recognize these three patterns quickly:

```text
"Connect everything with minimum total cost"
                ↓
               MST


"Are these nodes connected?"
                ↓
             DSU / DFS


"Minimum number of steps/moves"
                ↓
              BFS
```

That pattern recognition is more important in interviews than memorizing the implementation of Prim's or Kruskal's.
