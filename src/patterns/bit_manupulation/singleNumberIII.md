========================================
BIT MANIPULATION - QUICK NOTES
========================================

1. n & (n - 1)
----------------

Purpose:
Remove the rightmost (lowest) set bit (1).

Example:

n = 12

12     = 1100
11     = 1011

1100
&
1011
----
1000

Rightmost 1 is removed.

Rule:
n & (n - 1) -> removes one set bit


----------------------------------------
2. COUNT SET BITS
----------------------------------------

A set bit = bit with value 1.

Example:

12 = 1100

Number of set bits = 2

Code:

int result = 0;

while (n != 0) {
n = n & (n - 1);
result++;
}

return result;

Intuition:
Each iteration removes exactly one 1 bit.
Therefore, number of iterations = number of set bits.

Time: O(number of set bits)
Space: O(1)


----------------------------------------
3. n & -n
----------------------------------------

Purpose:
Extract / isolate the rightmost set bit.

Example:

n = 12

12  = 1100
-12 = 0100   (relevant lower bits)

1100
& 0100
------
0100

Answer = 4

Rule:

n & -n -> isolates the rightmost 1 bit


----------------------------------------
4. WHY n & -n WORKS
----------------------------------------

Negative numbers use Two's Complement.

To calculate -n:

1. Invert all bits
2. Add 1

Example:

n = 12

1100
invert:
0011
add 1:
0100

Therefore:

1100
& 0100
------
0100

Only the rightmost 1 remains.


----------------------------------------
5. XOR (^)
----------------------------------------

XOR returns 1 when bits are different.

Rules:

0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0

Example:

5 ^ 6

5 = 0101
6 = 0110

0101
^ 0110
------
0011

Answer = 3


Important intuition:

XOR = "different bits become 1"


----------------------------------------
6. MINIMUM XOR PAIR
----------------------------------------

Problem:
Find the minimum XOR of any pair in an array.

Approach:

1. Sort the array
2. Compare only adjacent elements
3. Keep the minimum XOR

Example:

[2, 4, 5, 7]

2 ^ 4 = 6
4 ^ 5 = 1
5 ^ 7 = 2

Answer = 1

Code:

Collections.sort(input);

int result = Integer.MAX_VALUE;

for (int i = 1; i < input.size(); i++) {
result = Math.min(
result,
input.get(i - 1) ^ input.get(i)
);
}

return result;

Complexity:
Sorting = O(N log N)
Traversal = O(N)

Overall = O(N log N)


----------------------------------------
7. MAGIC NUMBER - POWERS OF 5
----------------------------------------

A magic number can be represented as:

5^1, 5^2, 5^3, ...

or a sum of unique powers of 5.

First few:

1 -> 5
2 -> 25
3 -> 5 + 25 = 30
4 -> 125
5 -> 125 + 5 = 130
6 -> 125 + 25 = 150
7 -> 125 + 25 + 5 = 155

Key idea:

Use the BINARY representation of A.

Each set bit (1) tells us to include the
corresponding power of 5.

Example:

A = 5

5 in binary = 101

Bit 0 = 1 -> 5^1
Bit 1 = 0 -> don't include 5^2
Bit 2 = 1 -> 5^3

Answer:

5^1 + 5^3
= 5 + 125
= 130

Algorithm:

power = 5
answer = 0

while (A > 0):

    if lowest bit of A is 1:
        answer += power

    power *= 5
    A >>= 1


----------------------------------------
8. TWO IMPORTANT BIT TRICKS
----------------------------------------

n & (n - 1)
-> removes rightmost 1 bit

n & -n
-> isolates rightmost 1 bit


Example:

n = 12 = 1100

n & (n - 1):

1100
1011
----
1000

Removes the rightmost 1.


n & -n:

1100
0100
----
0100

Keeps only the rightmost 1.


========================================
MEMORY TRICK
========================================

Think:

n & (n - 1)
"REMOVE one 1"

n & -n
"KEEP one 1"

XOR (^)
"DIFFERENT bits become 1"
========================================