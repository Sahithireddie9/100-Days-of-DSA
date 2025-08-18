# Find Peak Element

A **peak element** is an element that is **strictly greater** than its neighbors.  

Given a **0-indexed integer array** `nums`, find a peak element and return its index.  
If the array contains multiple peaks, return the index of **any one of the peaks**.

You may imagine that:  
- `nums[-1] = -∞` (negative infinity)  
- `nums[n] = -∞` (negative infinity)  

In other words, an element is always considered greater than a neighbor that is outside the array.  

You must write an algorithm that runs in **O(log n)** time.

---

## Example 1
**Input:** nums = [1,2,3,1]
**Output:** 2
**Explanation:**  
`3` is a peak element and its index is `2`.

---
## Example 2 
**Input:** nums = [1,2,1,3,5,6,4]
**Output:** 5
**Explanation:**  
- The function can return index `1` (where `2` is a peak),  
- Or index `5` (where `6` is a peak).  
Both are valid answers.

---

## Constraints
- `1 <= nums.length <= 1000`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `nums[i] != nums[i + 1]` for all valid `i`

## Brute Force Approach (Linear Search)

**Intuition:**  
- Scan through each element and check if it is greater than its left and right neighbors.  
- If yes, return its index.  
Since boundaries are treated as `-∞`, only one neighbor needs to be checked at the edges.

**Pseudocode:**
```
for i from 0 to n-1:
    if (i == 0 OR nums[i] > nums[i-1]) AND (i == n-1 OR nums[i] > nums[i+1]):
        return i
```
**Time Complexity:**  
- `O(n)` (we scan all elements in the worst case)

**Space Complexity:**  
- `O(1)` (constant extra space)

---
## Optimal Approach (Binary Search)

**Intuition:**  
We want `O(log n)`, so we apply binary search. 

- A peak element is one that is greater than its neighbors.
- At the edges, we only need to check one neighbor:
- If the first element is greater than the second → it's a peak.
- If the last element is greater than the second last → it's a peak.
- Otherwise, we use binary search:
    - If nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] → mid is a peak.

    - If nums[mid] > nums[mid-1] → we are in an ascending slope, so a peak must lie on the right side.

    - Else → we are in a descending slope, so a peak must lie on the left side.

- This works because if the sequence is going up, there must eventually be a peak. If it is going down, there must also be a peak on the left side.

**Pseudocode:**
```
function findPeakElement(nums):
    n = length(nums)

    # Edge cases
    if n == 1:
        return 0
    if nums[0] > nums[1]:
        return 0
    if nums[n-1] > nums[n-2]:
        return n-1

    low = 1
    high = n - 2

    while low <= high:
        mid = (low + high) // 2

        # Check if mid is peak
        if nums[mid] > nums[mid-1] AND nums[mid] > nums[mid+1]:
            return mid

        # If in ascending slope, move right
        else if nums[mid] > nums[mid-1]:
            low = mid + 1

        # Else move left
        else:
            high = mid - 1

    return 0   # fallback (won’t usually reach here)
```

**Time Complexity:**  
- `O(log n)`

**Space Complexity:**  
- `O(1)`


