# Day 13 – Remove Element

## Problem Statement

Given an integer array `nums` and an integer `val`, remove **all occurrences** of `val` in-place. The **order of elements may change**, and it doesn't matter what you leave beyond the new length.

You must return the number of elements that are **not equal to `val`**, and modify `nums` in-place so that the first `k` elements of `nums` contain the non-`val` values.

---

## Examples

### Example 1:
**Input:**  
`nums = [3,2,2,3]`, `val = 3`  
**Output:**  
`2, nums = [2,2,_,_]`  
**Explanation:**  
Remove all 3s, keep 2s in the front.

---

### Example 2:
**Input:**  
`nums = [0,1,2,2,3,0,4,2]`, `val = 2`  
**Output:**  
`5, nums = [0,1,4,0,3,_,_,_]`  
**Explanation:**  
Remove all 2s, leave others in any order at the beginning.

---

## Optimal Approach – Two Pointers

### Intuition:

We don’t care about preserving order, so we can **overwrite** values we want to remove.  

Use a pointer `k` to keep track of where the next valid number should go.  
Loop through `nums`, and each time we find a number **not equal to `val`**, we place it at position `k` and increment `k`.

---

### Pseudocode:

```text
initialize k = 0

for i from 0 to nums.length - 1:
    if nums[i] != val:
        nums[k] = nums[i]
        k += 1

return k
```
## Time Complexity:
- O(n) — Traverse the array once.

## Space Complexity:
- O(1) — In-place modification, no extra memory used.
