## Problem Statement

You are given an integer array `nums` sorted in **non-decreasing** order (duplicates allowed).  
The array has been **rotated** at an unknown pivot index `k` (0 ≤ k < nums.length), resulting in a new array:

[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]

For example:  
If `nums = [0,1,2,4,4,4,5,6,6,7]` and `k = 5`,  
the rotated array becomes:  
`[4,5,6,6,7,0,1,2,4,4]`

Your task is to determine if the given `target` exists in the array.  
Return **true** if `target` is present, otherwise return **false**.

You must **minimize the number of operations**.

---

### Example 1
**Input:** nums = [2,5,6,0,0,1,2]   target = 0

**Output:** true
**Explanation:** 0 is present in the array.

---

### Example 2
**Input:** nums = [2,5,6,0,0,1,2] target = 3
**Output:** false
**Explanation:** 3 is not present in the array.

---

### Constraints
- 1 ≤ nums.length ≤ 5000  
- -10⁴ ≤ nums[i] ≤ 10⁴  
- nums is guaranteed to be rotated at some pivot  
- -10⁴ ≤ target ≤ 10⁴

## Brute Force Approach
- Check every element one by one.  
- If any element equals `target`, return `true`.  
- If you finish checking the whole array and don’t find it, return `false`.

This works regardless of rotation or duplicates, because you’re not relying on order—you just scan.

---


### Pseudocode
```
function search(nums, target):
    for i from 0 to length(nums) - 1:
        if nums[i] == target:
            return true
    return false
```
### Complexity
- **Time:** `O(n)` — you may check every element once.  
- **Space:** `O(0(1))` — no extra data structures used.


---
## Optimal Approach (Binary Search with Duplicates)
## Intuition

Think of the array like a **circularly shifted sorted list**.  
Normally, in a sorted array, we can easily use binary search because we know the order.  
But after rotation, one side of the array is still sorted, and the other side might not be.  
Our job is to figure out **which side is sorted** and then check if the target can lie in that side.

---

### Step 1: Check the middle
Take the middle element:
- If it is the target → return true.
- If not, decide which half to keep.

---

### Step 2: Handle duplicates
If `arr[low] == arr[mid] == arr[high]`, we cannot know which half is sorted.  
So, we simply **shrink the search space** by moving `low++` and `high--`.  
This gets rid of unnecessary equal values.

---

### Step 3: Identify the sorted half
- If `arr[low] <= arr[mid]`:  
  Left half is sorted.  
  - If the target lies in this range → move search to the left half.  
  - Otherwise → search in the right half.
  
- Else (means `arr[mid] <= arr[high]`):  
  Right half is sorted.  
  - If the target lies in this range → move search to the right half.  
  - Otherwise → search in the left half.

---

### Step 4: Keep shrinking
Repeat the above steps until:
- You find the target → return true.  
- Or `low > high` → return false.

## pseudocode
```
function search(nums, target):
    low = 0
    high = length(nums) - 1

    while low <= high:
        mid = (low + high) // 2

        # If mid is the target
        if nums[mid] == target:
            return true

        # Handle duplicates
        if nums[low] == nums[mid] and nums[mid] == nums[high]:
            low = low + 1
            high = high - 1
            continue

        # If left half is sorted
        if nums[low] <= nums[mid]:
            if nums[low] <= target <= nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        # Else right half is sorted
        else:
            if nums[mid] <= target <= nums[high]:
                low = mid + 1
            else:
                high = mid - 1

    return false
```

### Complexity
- **Time:** Worst case `O(n)` (when many duplicates exist).  
- **Space:** `O(1)`.