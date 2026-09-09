[//]: # (delete from the end)
For this problem, the breakthrough comes from asking the right question.

### 1. Start from the obvious solution

For:

```text
1 → 2 → 3 → 4 → 5
B = 2
```

You might first think:

> "I need to know the length."

If length = 5:

```text
target index = length - B = 3
```

So delete index `3`.

That's a perfectly reasonable first thought — **and your previous solution did exactly this.**

Then ask:

> "Can I find the node without calculating the length?"

That's where the two-pointer idea emerges.

---

### 2. Ask: "What information do I actually need?"

To delete the 2nd node from the end:

```text
1 → 2 → 3 → 4 → 5
            ↑
          target
```

You don't actually need the length.

You need to somehow know:

> "When I'm at the end, where is the node 2 positions behind me?"

That immediately suggests:

```text
slow
 ↓
1 → 2 → 3 → 4 → 5
            ↑
           fast
```

Maintain a **fixed gap of B**.

When `fast` reaches the end, `slow` automatically reaches the relevant position.

That's the insight.

---

# How to train this systematically

Don't train yourself to ask:

> "Which pattern is this?"

Instead train yourself to ask these **5 questions**.

### Question 1: What is the brute-force solution?

Example:

```text
Find length
→ calculate target index
→ traverse again
→ delete
```

This gives you a baseline.

### Question 2: What information am I calculating that I might avoid?

Here:

```text
length
```

Maybe I don't need it.

### Question 3: Can two things move at different speeds?

This is a **very powerful question**.

Whenever you see:

* from the end
* middle of linked list
* cycle
* kth element
* compare elements at different positions

think:

> **Can I maintain a relationship between two pointers?**

---

### Question 4: Can I maintain a fixed relationship?

Here:

```text
B = 2
```

Maintain:

```text
fast - slow = 2
```

Then:

```text
fast reaches end
        ↓
slow is automatically B positions behind
```

That's the entire trick.

---

### Question 5: Can I avoid storing information?

The problem explicitly says:

> **constant additional space**

That should make you suspicious of:

```text
Array
HashMap
length storage
```

and encourage:

```text
Pointers
In-place modification
```

---

# The bigger DSA skill

You want to develop this transformation:

```text
Problem statement
       ↓
What information do I need?
       ↓
Can I maintain that information dynamically?
       ↓
Can pointers / state encode it?
       ↓
What invariant can I maintain?
```

For this problem:

```text
Need position from end
        ↓
Don't want length
        ↓
Maintain gap B
        ↓
Two pointers
        ↓
When fast reaches end,
slow is at target predecessor
```

---

## This is how I'd recommend you practice

Since you're doing a lot of linked-list/DSA problems, **don't immediately look for the pattern name**.

For every new problem, spend **5–10 minutes** doing this:

### Phase 1 — Understand

Write:

```text
What exactly am I being asked to find/change?
```

### Phase 2 — Brute force

Ask:

```text
What is the dumbest correct solution?
```

### Phase 3 — Bottleneck

Ask:

```text
Why is that solution inefficient?
What information am I calculating unnecessarily?
```

### Phase 4 — Constraint

Ask:

```text
Why does the problem mention O(1) space?
Why is the list sorted?
Why are there two arrays?
Why does it say "from the end"?
```

**Problem constraints are clues.**

### Phase 5 — Invariant

Ask:

> "Can I maintain some relationship while traversing?"

This is where many of the "aha!" solutions come from.

---

## For example, look at the patterns you've been doing

You've recently worked through several problems. The goal should be to recognize the **underlying transformation**, not memorize individual solutions.

```text
Remove Nth from end
→ fixed gap between pointers

Find middle of linked list
→ different pointer speeds

Detect cycle
→ different pointer speeds

Merge sorted lists
→ maintain invariant about smallest remaining node

Remove duplicates
→ maintain previous unique node

Insert at index
→ reach previous node + rewire pointers
```

Notice something?

You're not really learning **5 linked-list algorithms**.

You're learning:

> **How can I maintain the right information while traversing the structure?**

That's the skill that transfers to new problems.

---

### And one important thing about your own progress

Your earlier solution using:

```text
find length
→ calculate index
→ call delete()
```

was **not a bad solution**.

In fact, that's exactly how you should think initially.

The next level is asking:

> **"Can I eliminate the extra traversal/calculation?"**

That progression — **correct brute force → identify unnecessary information → maintain it implicitly** — is exactly how you train the brain to discover these ideas rather than memorize them.
