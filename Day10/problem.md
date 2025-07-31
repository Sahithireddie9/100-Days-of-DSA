# Day 10: 26. Remove Duplicates from Sorted Array

## Problem Statement

Given an integer array `nums` **sorted in non-decreasing order**, remove the duplicates **in-place** so that each unique element appears **only once**.  

The relative order of the elements should be kept the same.  
Return the number of unique elements, `k`.

**Important:**
- Modify the array `nums` so that the first `k` elements contain the unique elements in the order they appeared.
- The elements beyond the first `k` positions do not matter.
- Do not allocate extra space; you must do this with O(1) extra memory.


## Examples

### Example 1
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation:
Your function should return k = 2, with the first two elements being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence the underscores).


### Example 2

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,,,,,_]
Explanation:
Your function should return k = 5, with the first five elements being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence the underscores).

## 📏 Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in **non-decreasing** order.


## Optimal Approach (Two Pointers)

### Idea
- The array is **sorted**, so duplicates are always next to each other.  
- We use **two pointers**:
  - `i` → the place where the **next unique number** should go  
  - `j` → scans through the array

Whenever `nums[j]` is **different** from `nums[i]`:
1. Move `i` forward by 1  
2. Put `nums[j]` at `nums[i]`  

At the end, the first `i + 1` numbers in the array will be the unique values.

### 📋 Pseudocode
```i = 0
for j = 1 to n-1:
    if nums[j] != nums[i]:
        i = i + 1
        nums[i] = nums[j]

return i + 1
```

### ⏱ Time Complexity
- **O(n)** → we look at each number only once.

### 🧠 Space Complexity
- **O(1)** → no extra space, we just use the same array.


