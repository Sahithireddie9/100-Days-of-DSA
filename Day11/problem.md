# Day 11: 977. Squares of a Sorted Array

## Problem Statement
Given an integer array `nums` sorted in non-decreasing order, return an array of the **squares** of each number, **sorted** in non-decreasing order.

---

## Examples
**Example 1**
Input: nums = [-4, -1, 0, 3, 10]
Output: [0, 1, 9, 16, 100]


**Example 2**
Input: nums = [-7, -3, 2, 3, 11]
Output: [4, 9, 9, 49, 121]


---

## Brute Force

### Intuition
Square every element, then sort the array.

### Pseudocode
```
for i in 0..n-1:
    nums[i] = nums[i] * nums[i]
sort(nums)
return nums
```

### Time Complexity
- `O(n log n)` (sorting dominates)

### Space Complexity
- `O(1)` extra (in-place squaring; sort may be in-place depending on implementation)

---

## Optimal – Two Pointers

### Intuition
The largest square comes from the **largest absolute value**, which is at either array **end** (left for big negatives, right for big positives).
Use two pointers (`l` at start, `r` at end) and fill the result array from the **back** with the larger square each step.

### Pseudocode
```
l = 0
r = n - 1
res = new array of size n
pos = n - 1
while l <= r:
    if abs(nums[l]) > abs(nums[r]):
        res[pos] = nums[l] * nums[l]
        l += 1
    else:
        res[pos] = nums[r] * nums[r]
        r -= 1
    pos -= 1
return res
```


### Time Complexity
- `O(n)` — each element processed once

### Space Complexity
- `O(1)` extra besides the output array

---




