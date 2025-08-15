## Problem Statement

You are given an integer array `nums` **sorted in ascending order** (with distinct values).  
Prior to being passed to your function, `nums` is possibly **rotated** at an unknown index `k`  
(`1 <= k < nums.length`) such that the resulting array is:[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]].For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.


**Example 1:**
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

**Example 2:**
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

**Example 3:**
Input: nums = [1], target = 0
Output: -1

## Brute Force Approach
- 1.Traverse through the array linearly and compare each element with the `target`.  
- 2.If found, return the index. Otherwise, return `-1`.

---

### Pseudocode
```
for i from 0 to nums.length - 1:
    if nums[i] == target:
        return i
return -1
```
- **Time Complexity:** `O(n)` — We may check every element in the array.
- **Space Complexity:** `O(1)` — No extra space is used apart from variables.


## Optimal Approach

1. **Check if mid is the target**  
   If `nums[mid] == target`, we have found the answer immediately.

2. **Check if the left half is sorted**  
   Condition: `nums[mid] >= nums[low]`  
   - This means from `low` to `mid` the numbers are in ascending order.
   - If `target` lies between `nums[low]` and `nums[mid]` (inclusive of `low`, exclusive of `mid`),  
     it must be in the **left half**, so we move `high = mid - 1`.
   - Otherwise, the target is in the **right half**, so we move `low = mid + 1`.

3. **Otherwise, the right half is sorted**  
   If the left half isn’t sorted, then the right half (`mid` to `high`) must be sorted.
   - If `target` lies between `nums[mid]` and `nums[high]` (exclusive of `mid`, inclusive of `high`),  
     it must be in the **right half**, so we move `low = mid + 1`.
   - Otherwise, the target is in the **left half**, so we move `high = mid - 1`.

4. **Repeat until found or exhausted**  
   Keep narrowing down the search range until `low > high`, in which case the target isn’t present.

---
```
function search(nums, target):
    low = 0
    high = length(nums) - 1

    while low <= high:
        mid = (low + high) // 2

        if nums[mid] == target:
            return mid

        # Left half is sorted
        if nums[mid] >= nums[low]:
            if target >= nums[low] AND target < nums[mid]:
                high = mid - 1     # search left half
            else:
                low = mid + 1      # search right half

        # Right half is sorted
        else:
            if target > nums[mid] AND target <= nums[high]:
                low = mid + 1      # search right half
            else:
                high = mid - 1     # search left half

    return -1
```


- **Time Complexity:** `O(log n)`  
- **Space Complexity:** `O(1)`  




