# Day 16 – Is Subsequence

## Problem Statement

Given two strings `s` and `t`, return `true` if `s` is a **subsequence** of `t`, or `false` otherwise.

A **subsequence** of a string is a new string formed from the original string by deleting some (can be none) of the characters **without disturbing the relative order** of the remaining characters.

---

## Examples

### Example 1:
**Input:**  
s = `"abc"`  
t = `"ahbgdc"`  
**Output:** `true`  
**Explanation:**  
We can form "abc" from "ahbgdc" by deleting 'h', 'g', and 'd'.

---

### Example 2:
**Input:**  
s = `"axc"`  
t = `"ahbgdc"`  
**Output:** `false`  
**Explanation:**  
We can't form "axc" from "ahbgdc" as 'x' doesn't appear in `t`.

---

## Constraints

- 0 <= s.length <= 100  
- 0 <= t.length <= 10⁴  
- `s` and `t` consist only of lowercase English letters

---

## Optimal Approach – Two Pointer Technique

### Intuition:

- Use **two pointers**:  
  - One iterates over `s`,  
  - The other over `t`.  
- Try to **match each character of `s`** with characters in `t` by scanning left to right.
- If all characters of `s` are matched in order, then `s` is a subsequence of `t`.

---

### Pseudocode:

```text
Initialize pointer1 = 0 (for s)
Initialize pointer2 = 0 (for t)

while pointer1 < length of s and pointer2 < length of t:
    if s[pointer1] == t[pointer2]:
        pointer1++
    pointer2++

if pointer1 == length of s:
    return true
else:
    return false
```

## Time Complexity:
- O(n), where n = t.length() — We traverse t only once.

## Space Complexity:
- O(1) — No extra space used.

