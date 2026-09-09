https://www.youtube.com/watch?v=VJkvPTY6kZw

https://www.youtube.com/watch?v=9Vm4B6aD4hc&list=PLk_DdB3uhk2AQalRT2sFhEtatiwaik_YJ

========================================
COMBINATORICS - QUICK NOTES
========================================

1. BASIC COUNTING
----------------------------------------

If a task has:

A ways for step 1
B ways for step 2

Total ways:

A * B

Example:
3 shirts and 2 pants

Ways = 3 * 2 = 6


----------------------------------------
2. ADDITION RULE
----------------------------------------

If choices are mutually exclusive:

Total = A + B

Example:
Choose either:
3 Java problems OR
4 SQL problems

Total = 3 + 4 = 7


========================================
3. FACTORIAL
   ========================================

n! = n * (n-1) * (n-2) * ... * 1

Examples:

5! = 5 * 4 * 3 * 2 * 1 = 120

0! = 1


========================================
4. PERMUTATION
   ========================================

Order MATTERS.

Number of ways to arrange r objects
from n objects:

P(n,r) = n! / (n-r)!

Example:

Choose and arrange 2 people from 5:

P(5,2)
= 5! / 3!
= 5 * 4
= 20


Special case:

Arrange all n objects:

P(n,n) = n!


Example:

A B C

3! = 6 arrangements


========================================
5. COMBINATION
   ========================================

Order DOES NOT matter.

Choose r objects from n:

C(n,r) = n! / (r! * (n-r)!)

Also written:

nCr

Example:

Choose 2 people from 5:

C(5,2)
= 5! / (2! * 3!)
= 10


IMPORTANT:

Permutation -> order matters
Combination -> order doesn't matter


Example:

Choose A and B:

AB and BA

Permutation:
different

Combination:
same


========================================
6. RELATION BETWEEN P AND C
   ========================================

P(n,r) = C(n,r) * r!

Why?

First choose r objects:

C(n,r)

Then arrange them:

r!

Therefore:

P(n,r) = C(n,r) * r!


========================================
7. nCr SYMMETRY
   ========================================

C(n,r) = C(n,n-r)

Example:

C(10,2) = C(10,8)

This is useful because calculating
the smaller r is usually easier.


========================================
8. PASCAL'S TRIANGLE
   ========================================

Each number is the sum of the two numbers
above it.

        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1

Row n contains:

C(n,0), C(n,1), ..., C(n,n)


Important identity:

C(n,r) = C(n-1,r-1) + C(n-1,r)


========================================
9. SUBSETS
   ========================================

For N elements:

Number of subsets = 2^N

Why?

Every element has 2 choices:

include
OR
exclude

Therefore:

2 * 2 * ... * 2
= 2^N


Example:

[1,2,3]

Subsets:

{}
{1}
{2}
{3}
{1,2}
{1,3}
{2,3}
{1,2,3}

Total = 8 = 2^3


========================================
10. NON-EMPTY SUBSETS
    ========================================

Total subsets:

2^N

Remove empty subset:

2^N - 1


Example:

N = 3

Non-empty subsets = 7


========================================
11. SUBARRAYS
    ========================================

Number of subarrays of an array of size N:

N * (N + 1) / 2

Example:

N = 4

4 * 5 / 2 = 10


Why?

Starting at index 0:
4 subarrays

Starting at index 1:
3

Starting at index 2:
2

Starting at index 3:
1

Total:

4 + 3 + 2 + 1 = 10


========================================
12. SUBSEQUENCES
    ========================================

Every element can be:

included
OR
excluded

Therefore:

Number of subsequences = 2^N

Non-empty subsequences:

2^N - 1

NOTE:

Subsequence maintains ORDER.

Subset does not care about order.


========================================
13. PAIRS
    ========================================

Choose 2 elements from N:

C(N,2)

= N(N-1)/2


Example:

N = 5

Pairs = 5 * 4 / 2
= 10


========================================
14. TRIPLETS
    ========================================

Choose 3 elements from N:

C(N,3)

= N(N-1)(N-2) / 6


Example:

N = 5

C(5,3)
= 5*4*3 / 6
= 10


========================================
15. CHOOSING WITH REPETITION
    ========================================

Choose r objects from n types,
where repetition is allowed:

C(n+r-1, r)

Example:

Choose 3 candies from 5 types,
repetition allowed:

C(5+3-1, 3)
= C(7,3)
= 35


========================================
16. ARRANGEMENTS WITH DUPLICATES
    ========================================

If total objects = N

and duplicates have frequencies:

a, b, c, ...

Number of distinct arrangements:

N! / (a! * b! * c! * ...)


Example:

A A B

Total = 3

A occurs 2 times.

Ways:

3! / 2!
= 3

AAB
ABA
BAA


========================================
17. CIRCULAR PERMUTATION
    ========================================

Arrange N DISTINCT objects in a circle:

(N-1)!

Example:

5 people around a table:

(5-1)!
= 4!
= 24


========================================
18. COMPLEMENT COUNTING
    ========================================

Sometimes easier:

Answer = Total - Invalid

Example:

Number of binary strings of length N
containing at least one 1.

Total strings:

2^N

Only string without 1:

000...000

Answer:

2^N - 1


========================================
19. MODULO
    ========================================

For large combinatorics answers,
we usually calculate:

answer % MOD

Common:

MOD = 1,000,000,007


Important:

(a + b) % MOD
= ((a % MOD) + (b % MOD)) % MOD

(a * b) % MOD
= ((a % MOD) * (b % MOD)) % MOD


Division is NOT directly valid under modulo.

For:

nCr % MOD

usually use:

modular inverse

if MOD is prime.


========================================
20. QUICK INTERVIEW PATTERNS
    ========================================

Question asks:

"Choose r from n"
↓
Combination
↓
C(n,r)


"Arrange r from n"
↓
Permutation
↓
P(n,r)


"How many subsets?"
↓
2^N


"How many non-empty subsets?"
↓
2^N - 1


"How many subarrays?"
↓
N(N+1)/2


"How many pairs?"
↓
N(N-1)/2


"How many triplets?"
↓
N(N-1)(N-2)/6


"Order matters?"
↓
Permutation


"Order doesn't matter?"
↓
Combination


========================================
MEMORY TRICK
========================================

PERMUTATION
-> POSITION matters
-> Arrange
-> nPr

COMBINATION
-> CHOOSE
-> Order doesn't matter
-> nCr

SUBSET
-> Include / Exclude
-> 2^N

SUBARRAY
-> CONTIGUOUS
-> N(N+1)/2

SUBSEQUENCE
-> ORDER maintained
-> 2^N


========================================
MOST IMPORTANT FORMULAS
========================================

n! = n(n-1)!

P(n,r) = n!/(n-r)!

C(n,r) = n!/[r!(n-r)!]

P(n,r) = C(n,r) * r!

C(n,r) = C(n,n-r)

Subsets = 2^N

Non-empty subsets = 2^N - 1

Subarrays = N(N+1)/2

Pairs = N(N-1)/2

Triplets = N(N-1)(N-2)/6

Circular permutation = (N-1)!
========================================
