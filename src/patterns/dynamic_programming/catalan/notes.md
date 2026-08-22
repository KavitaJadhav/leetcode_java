Yes. For interviews, I would remember **just these 5 things** for “Maximum/Number of BSTs up to N”:

### 1. It's a Catalan problem

If the question says:

> **How many unique BSTs can be formed with N distinct numbers?**

Think immediately:

**Catalan Number → DP**

---

### 2. The root is the key

For `N` nodes, try every node as the root.

If root is at position `i`:

```text
left  = i - 1 nodes
right = N - i nodes
```

Therefore:

```text
ways = dp[left] * dp[right]
```

---

### 3. The recurrence

The most important thing to memorize:

```text
dp[n] = Σ dp[i-1] * dp[n-i]
        i=1..n
```

Or mentally:

> **left possibilities × right possibilities, for every root**

---

### 4. Base case

```text
dp[0] = 1
dp[1] = 1
```

The `dp[0] = 1` is particularly important.

Why?

An empty subtree represents **one valid possibility**.

For example, with root `1`:

```text
1
 \
  ...
```

The left subtree is empty, but that's still **one way**.

---

### 5. Recognize the Catalan sequence

You don't necessarily need to memorize the formula, but recognizing these numbers helps:

```text
N:     0   1   2   3   4   5   6
       ↓   ↓   ↓   ↓   ↓   ↓   ↓
ways:  1   1   2   5  14  42 132
```

### Interview mental template

When you see **"count unique BSTs"**, think:

```text
How many choices for root?
        ↓
For each root:
        ↓
left BSTs × right BSTs
        ↓
sum
        ↓
Catalan
```

One subtle point: **this counts structurally unique BSTs using `1..N` once each**. It is not asking for the maximum height, maximum nodes, or maximum value.

| #  | Problem                                                         | Catalan connection |
| -- | --------------------------------------------------------------- | ------------------ |
| 1  | **Count Unique BSTs with N nodes**                              | Direct Catalan     |
| 2  | **Number of ways to triangulate a polygon**                     | Catalan            |
| 3  | **Number of valid parentheses combinations**                    | Catalan            |
| 4  | **Number of ways to fully parenthesize an expression**          | Catalan            |
| 5  | **Number of full binary trees with N internal nodes**           | Catalan            |
| 6  | **Number of non-crossing handshakes**                           | Catalan            |
| 7  | **Number of ways to divide a polygon into triangles**           | Catalan            |
| 8  | **Number of monotonic lattice paths that don't cross diagonal** | Catalan            |
| 9  | **Number of stack-sortable permutations**                       | Catalan            |
| 10 | **Number of non-crossing partitions**                           | Catalan            |
