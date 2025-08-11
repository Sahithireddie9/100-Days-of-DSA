# Kadane’s Algorithm (Maximum Subarray)

Find the **maximum sum of any contiguous subarray** in a 1D array.

---

## Problem Statement
Given an integer array `nums`, return the **largest possible sum** of a **contiguous** subarray (at least one element).

> Example  
> `nums = [-2,1,-3,4,-1,2,1,-5,4]` → **6**, from subarray `[4, -1, 2, 1]`.

---

## Intuition
- 1.Scan left → right while keeping a **running sum**.  
- 2.If the running sum becomes **worse than just starting at the current number**, **start fresh** at the current number.  
- 3.Always remember the **best sum seen so far**.

> Key idea: a negative running sum only *hurts* anything that comes after it—drop it.

---

## Algorithm (Step-by-step)
1. Set `curr = nums[0]` and `best = nums[0]`.
2. For each next element `x` in `nums`:
   - Update the running best ending here: `curr = max(x, curr + x)`
   - Update the overall best: `best = max(best, curr)`
3. Return `best`.

This also correctly handles arrays with all negative numbers.

---

## Pseudocode
```text
function kadane(nums):
    curr = nums[0]
    best = nums[0]
    for i from 1 to n-1:
        curr = max(nums[i], curr + nums[i])  // start fresh or extend
        best = max(best, curr)                // record global best
    return best
```

---

## Dry Run (Example)
Array: `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`

| i | x   | curr (max ending here)  | best (so far) | Action                                 |
|---|-----|-------------------------|---------------|----------------------------------------|
| 0 | -2  | -2                      | -2            | Init                                   |
| 1 | 1   | max(1, -2+1)=1          | 1             | Start fresh at 1                       |
| 2 | -3  | max(-3, 1-3)=-2         | 1             | Extend then becomes -2                 |
| 3 | 4   | max(4, -2+4)=4          | 4             | Start fresh at 4                       |
| 4 | -1  | max(-1, 4-1)=3          | 4             | Extend (4→3)                           |
| 5 | 2   | max(2, 3+2)=5           | 5             | Extend (3→5)                           |
| 6 | 1   | max(1, 5+1)=6           | 6             | Extend (5→6)                           |
| 7 | -5  | max(-5, 6-5)=1          | 6             | Extend (6→1)                           |
| 8 | 4   | max(4, 1+4)=5           | 6             | Extend (1→5)                           |

**Answer = 6**, from `[4, -1, 2, 1]`.

---

## Complexity
- **Time:** `O(n)` (single pass)
- **Space:** `O(1)` (constant extra space)

---

## Edge Cases & Notes
- **All negatives:** The algorithm still works because we compare `x` vs. `curr + x`; it picks the least negative single element.
- **Empty array:** Typical problem constraints require at least one element. If empty arrays are allowed, define what to return (e.g., `0`) explicitly in the spec.
- **Indices (optional):** To recover the actual subarray, track a temporary start index when `x > curr + x` and update the final `(start, end)` when you improve `best`.
