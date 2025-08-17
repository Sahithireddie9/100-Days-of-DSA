## Problem Statement
You are given a **sorted array** consisting of only integers where every element appears **exactly twice**, except for **one element** which appears exactly once.  

Return the single element that appears only once.  

Your solution must run in **O(log n)** time and **O(1)** space.

---

## Example 1
**Input:** nums = [1,1,2,3,3,4,4,8,8]
**Output:** 2



## Example 2
**Input:**  nums = [3,3,7,7,10,11,11]
**Output:** 10

## Constraints
- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^5`


## Brute Force Approach
### Intuition
- Since the array is sorted, pairs of numbers should appear consecutively.
- Loop through the array:
  - Compare each element with the next one.
  - If they are not equal, that element is the single element.
- If no mismatch is found, the last element is the single one.

### Pseudocode
```for i from 0 to n-2 step 2:
    if nums[i] != nums[i+1]:
    return nums[i]
return nums[n-1]
```

## Optimal Approach (Binary Search)
### Intuition
- In the sorted array, every number appears in pairs except one.
- Before the single number, pairs start at even indices: (0,1) (2,3) ...
- After the single number, the pairing flips and starts at odd indices.
- Use binary search to find where this pattern breaks:
- Force mid to be even.
- If nums[mid] == nums[mid+1], the single is on the right.
- Otherwise it’s on the left (including mid).

### Pseudocode
1. Initialize `low = 0`, `high = n-1`.
2. While `low < high`:
   - Compute `mid = (low + high) // 2`.
   - Ensure `mid` is even (if odd, shift left by 1).
   - If `nums[mid] == nums[mid+1]`, the single element is **to the right** → move `low = mid + 2`.
   - Otherwise, the single element is **to the left** → move `high = mid`.
3. Return `nums[low]`.

### Pseudocode
```
function singleNonDuplicate(nums):
    low = 0
    high = length(nums) - 1

    while low < high:
        mid = (low + high) // 2
        if mid is odd:
            mid = mid - 1          # make mid even

        if nums[mid] == nums[mid + 1]:
            low = mid + 2          # valid pair; go right
        else:
            high = mid             # broken pair; go left (mid could be the answer)

    return nums[low]
```



