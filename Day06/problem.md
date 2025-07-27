# Day 6: Minimum Size Subarray Sum

## Problem Statement

Given an array of positive integers `nums` and a positive integer `target`, return the **minimal length** of a contiguous subarray of which the sum is **greater than or equal to** `target`. If there is no such subarray, return `0` instead.

---

## Examples

**Example 1:**
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length.


**Example 2:**
Input: target = 4, nums = [1,4,4]
Output: 1


**Example 3:**
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

---

## Brute Force Approach

### Intuition

Try every possible subarray starting from each index. For each starting point, keep adding elements until the sum is ≥ target. Track the length of such valid subarrays and return the smallest one.

---

### Pseudocode
```
minLen = ∞

for i = 0 to n - 1:
    sum = 0
    for j = i to n - 1:
        sum += nums[j]
        if sum >= target:
            minLen = min(minLen, j - i + 1)
            break

return minLen == ∞ ? 0 : minLen```

---

### Time Complexity

- O(n²) – Two nested loops.

### Space Complexity

- O(1) – No extra space used.

---

## Optimal Approach (Sliding Window)

### Intuition

Use two pointers to create a sliding window. Expand the window by moving `right` until the sum ≥ target. Then, shrink the window from the left as long as the sum stays valid. Keep updating the minimal window size.

---

### Pseudocode

left = 0, right = 0
currentSum = 0
minLen = ∞

while right < n:
    currentSum += nums[right]
    right++

    while currentSum >= target:
        minLen = min(minLen, right - left)
        currentSum -= nums[left]
        left++
return minLen == ∞ ? 0 : minLen

---

### Time Complexity

- O(n) – Each element is visited at most twice (once by `right`, once by `left`).

### Space Complexity

- O(1) – No additional space used.

---



