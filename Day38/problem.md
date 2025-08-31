# Daily Temperatures — Study Sheet

## ✅ Problem Statement
You are given an integer array `temperatures` where `temperatures[i]` is the temperature on day `i`.
Return an integer array `result` where `result[i]` is the number of days *after* day `i` until a **warmer** temperature appears.
If there is **no** future day with a warmer temperature, set `result[i] = 0`.

### Examples
**Example 1**  
Input: `temperatures = [30, 38, 30, 36, 35, 40, 28]`  
Output: `result = [1, 4, 1, 2, 1, 0, 0]`  
**Why?**
- Day 0 (30) → next warmer is 38 at day 1 → wait **1**
- Day 1 (38) → next warmer is 40 at day 5 → wait **4**
- Day 2 (30) → next warmer is 36 at day 3 → wait **1**
- Day 3 (36) → next warmer is 40 at day 5 → wait **2**
- Day 4 (35) → next warmer is 40 at day 5 → wait **1**
- Day 5 (40) → no warmer later → **0**
- Day 6 (28) → no warmer later → **0**

**Example 2**  
Input: `temperatures = [22, 21, 20]`  
Output: `result = [0, 0, 0]` (no warmer future day for any index)

---

## 🧠 Brute-Force Intuition
For each day `i`, scan all future days `j > i` until you find `temperatures[j] > temperatures[i]`.  
The first such `j` gives `result[i] = j - i`. If none found, `result[i] = 0`.

### Brute-Force Pseudocode
```
function dailyTemperaturesBrute(temperatures):
    n = length(temperatures)
    result = array of zeros length n
    for i from 0 to n-1:
        for j from i+1 to n-1:
            if temperatures[j] > temperatures[i]:
                result[i] = j - i
                break
    return result
```

**Time Complexity:** `O(n^2)` — nested loops over the array.  
**Space Complexity:** `O(1)` extra (excluding output).

---

## ⚡ Optimal Intuition — Monotonic Decreasing Stack
Use a stack to keep **indices** of days with temperatures forming a **strictly decreasing** sequence from bottom to top.
As you iterate forward:
- While the current temperature is **warmer** than the temperature at the **top index** of the stack, pop that index `idx` and set `result[idx] = current_index - idx` (we just found the next warmer day for `idx`).
- Push the current index onto the stack.
- Any indices left in the stack at the end have no warmer future day → stay `0`.

This ensures each index is **pushed and popped at most once** → linear time.

### Optimal Pseudocode (Monotonic Stack)
```
function dailyTemperatures(temperatures):
    n = length(temperatures)
    result = array of zeros length n
    stack = empty stack  // will store indices

    for i from 0 to n-1:
        while stack is not empty and temperatures[i] > temperatures[stack.top()]:
            idx = stack.pop()
            result[idx] = i - idx
        stack.push(i)

    return result
```

**Time Complexity:** `O(n)` — each index is pushed & popped at most once.  
**Space Complexity:** `O(n)` — for the stack in the worst case (strictly decreasing temps).

---

## ✅ Edge Cases to Consider
- Strictly decreasing temperatures (e.g., `[5,4,3,2,1]`) → all zeros.
- Strictly increasing temperatures (e.g., `[1,2,3,4]`) → `result[i] = 1` for all but last.
- Repeated equal temperatures (e.g., `[70,70,70]`) → all zeros.
- Single element (e.g., `[42]`) → `[0]`.

---

## 📊 Complexity Summary
| Approach | Time | Space | Notes |
|---         |---|---|---|
| Brute Force | O(n^2) | O(1) | Check every future day |
| Monotonic Stack (Optimal) | O(n) | O(n) | Each index pushed/popped once |