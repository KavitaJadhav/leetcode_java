## Intuition

We need `X` and `Y` such that:

```text
A ^ X = A + X
A ^ Y = A + Y
```

### 1. Key observation

For binary numbers:

```text
A ^ B = A + B
```

**iff there is no carry** during addition.

Carry happens when both numbers have `1` at the same position.

Therefore:

```text
(A & B) == 0
```

So the problem becomes:

> Find numbers that have **no common set bits** with `A`.

---

### 2. Find X — greatest number smaller than A

Suppose:

```text
A = 1010
```

Available positions for X are only where A has `0`:

```text
A = 1010
X = 0101
```

To make X as large as possible, set **all available 0-bits below A's highest bit**.

So:

```text
X = complement of A
    restricted to bits below highest set bit
```

Example:

```text
A = 1101

below highest bit:
    101

complement:
    010

X = 2
```

---

### 3. Find Y — smallest number greater than A

Any number using only the lower bits cannot be greater than A.

Therefore, the smallest valid number greater than A must use a **new higher bit**.

That means:

```text
Y = next power of 2
```

Example:

```text
A = 1101 = 13

Y = 10000 = 16
```

There is no overlap:

```text
1101
10000
----
00000
```

---

### 4. Final formula

Let `highestBit` = position of the highest `1` in A.

```java
X = (~A) & ((1 << highestBit) - 1);

Y = 1 << (highestBit + 1);

answer = X ^ Y;
```

### Pattern to remember

```text
XOR = SUM
   ↓
No carry
   ↓
A & X = 0
   ↓
X → use zero bits below MSB
Y → next power of 2
```

**Core bit pattern:** `XOR + AND + MSB/next power of 2`.
