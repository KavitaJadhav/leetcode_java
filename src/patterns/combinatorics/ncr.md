# NCR (nCr) — Combination using DP

## Formula

$$
\boxed{C(n,r)=C(n-1,r)+C(n-1,r-1)}
$$

### Intuition

To choose `r` items from `n` items, consider the last item:

* **Don't choose it** → choose `r` from previous `n-1`

    * `C(n-1, r)`
* **Choose it** → choose remaining `r-1` from previous `n-1`

    * `C(n-1, r-1)`

Therefore:

```text
C(n,r) = C(n-1,r) + C(n-1,r-1)
```

---

## Base Case

```text
C(n,0) = 1
```

There is exactly one way to choose zero items.

So:

```java
dp[0] = 1;
```

---

## 2D DP

Normally:

```text
dp[i][j] = C(i,j)
```

Example:

```text
       1
      1 1
     1 2 1
    1 3 3 1
   1 4 6 4 1
```

---

# 1D DP Optimization

Instead of:

```java
int[][] dp;
```

use:

```java
int[] dp;
```

Meaning:

```text
dp[j] = C(currentRow, j)
```

Code:

```java
int[] dp = new int[r + 1];

dp[0] = 1;

for (int i = 1; i <= n; i++) {
    for (int j = Math.min(i, r); j >= 1; j--) {
        dp[j] = dp[j] + dp[j - 1];
    }
}
```

## IMPORTANT: Iterate RIGHT → LEFT

```text
for (j = ...; j >= 1; j--)
```

Why?

Because `dp[j-1]` must still contain the value from the **previous row**.

Example:

```text
Before:
dp[1] = C(4,1) = 4
dp[2] = C(4,2) = 6

Calculate:
dp[2] = dp[2] + dp[1]
      = 6 + 4
      = 10
```

Only after using `dp[1]` for `dp[2]` do we update `dp[1]`.

If we went LEFT → RIGHT, `dp[1]` would already have the new value and would incorrectly be used for `dp[2]`.

### Rule to remember

> **1D Pascal's Triangle → iterate backwards.**

---

# Example: 5C2

Start:

```text
dp = [1, 0, 0]
```

After `i = 1`:

```text
[1, 1, 0]
```

After `i = 2`:

```text
[1, 2, 1]
```

After `i = 3`:

```text
[1, 3, 3]
```

After `i = 4`:

```text
[1, 4, 6]
```

After `i = 5`:

```text
[1, 5, 10]
```

Therefore:

```text
dp[2] = 10

5C2 = 10
```

---

# Why Math.min(i, r)?

```java
Math.min(i, r)
```

We only need values up to `r`.

For example, for:

```text
n = 5
r = 2
```

we only calculate:

```text
C(i,0)
C(i,1)
C(i,2)
```

No need to calculate `C(i,3)`, `C(i,4)`, etc.

---

# Modulo

If the answer can become very large:

```java
dp[j] = ((dp[j] % m) + (dp[j - 1] % m)) % m;
```

This calculates:

```text
C(n,r) % m
```

Modulo can safely be applied during the DP because:

```text
(a + b) % m
=
((a % m) + (b % m)) % m
```

---

# Complexity

Using 1D DP:

```text
Time  = O(n × r)
Space = O(r)
```

If `r > n`, answer is:

```text
0
```

---

# Connection to Catalan Numbers

NCR uses:

```text
C(n,r) = C(n-1,r) + C(n-1,r-1)
```

Catalan numbers use:

```text
Catalan(n)
= Σ Catalan(i) × Catalan(n-1-i)
```

Catalan numbers are also related to NCR:

```text
Catalan(n) = C(2n,n) / (n+1)
```

First Catalan numbers:

```text
1, 1, 2, 5, 14, 42, 132, ...
```

### Interview recognition

```text
NCR
 ↓
Pascal's Triangle
 ↓
C(n,r) = C(n-1,r) + C(n-1,r-1)
 ↓
2D DP
 ↓
1D optimization
 ↓
RIGHT → LEFT iteration
```

**Most important thing to remember:**

> When compressing Pascal's Triangle from 2D to 1D, update `j` from **right to left** so that `dp[j-1]` is still the previous-row value.
