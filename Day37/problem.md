# Remove K Digits 

> **Goal:** Given a numeric string `num` and integer `k`, remove exactly `k` digits so the resulting integer (as a string) is the **smallest possible**. Remove leading zeros in the final answer (unless the result is just `"0"`).

---

## Problem Statement

**Input**: 
- `num` — string representing a non‑negative integer, length `1 .. 1e5`, no leading zeros (unless `"0"` itself)
- `k` — integer `1 .. |num|`

**Output**: 
- Smallest possible string after removing exactly `k` digits and stripping leading zeros (return `"0"` if empty).

---

## Examples

### Example 1
**Input:** `num = "1432219"`, `k = 3`  
**Output:** `"1219"`  
**Why:** Remove `4`, `3`, and `2` → smallest is `1219`.

### Example 2
**Input:** `num = "10200"`, `k = 1`  
**Output:** `"200"`  
**Why:** Remove leading `1` → `0200` → strip leading zeros → `200`.

### Example 3
**Input:** `num = "10"`, `k = 2`  
**Output:** `"0"`  
**Why:** Remove all digits.

---

## Edge Cases
- `k == |num|` → answer is `"0"`.
- Non‑decreasing digits (e.g., `"112233"`): deletions fall at the **end**.
- Strictly decreasing digits (e.g., `"9876"`): deletions happen from the **front/left**.
- Always strip **leading zeros** at the end.

---

## Approach A — Simple Greedy (O(nk))

**Intuition:** Repeat `k` times: scan left→right and remove the **first** digit where `num[i] > num[i+1]`. If none, remove the **last** digit. Finally, strip leading zeros.

### Pseudocode (Approach A)

```text
function removeKdigits_simple(num, k):
    if k == length(num): return "0"
    s = list(num)
    repeat k times:
        i = 0
        while i+1 < len(s) and s[i] <= s[i+1]:
            i += 1
        delete s[i]
    # strip leading zeros once at the end
    i = 0
    while i < len(s) and s[i] == '0':
        i += 1
    ans = join(s[i:])
    return ans if ans != "" else "0"
```

**Time Complexity:** Worst‑case `O(nk)`  
**Space Complexity:** `O(n)`

---

## Approach B — Optimal Monotonic Stack (O(n))

**Idea:** Maintain an **increasing** stack of digits. For each digit `d` in `num`, while `k > 0` and top of stack `> d`, **pop**. Push `d`. After scanning, if `k > 0`, pop from the **end**. Then strip leading zeros. If empty, return `"0"`.

### Why it works
Removing a larger digit that appears **before** a smaller digit produces a smaller prefix, which lexicographically minimizes the entire number. Each digit is pushed/popped at most once → `O(n)`.

### Pseudocode (Approach B)

```text
function removeKdigits(num, k):
    stack = []
    for d in num:
        while k > 0 and stack not empty and stack[-1] > d:
            pop(stack)
            k -= 1
        push(stack, d)

    while k > 0 and stack not empty:
        pop(stack); k -= 1

    ans = join(stack)
    remove leading zeros from ans
    if ans == "": return "0"
    return ans
```

**Time Complexity:** `O(n)`  
**Space Complexity:** `O(n)`

---



## Test Cases
- `num = "9", k = 1` → `"0"`
- `num = "112", k = 1` → `"11"`
- `num = "123456", k = 3` → `"123"`
- `num = "100200", k = 1` → `"200"`
- `num = "765028321", k = 5` → check mixed rises/dips

---

## Takeaways
- Use the **monotonic stack** for `O(n)` performance.
- Always **strip leading zeros**; if nothing left, return `"0"`.
