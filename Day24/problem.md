## Problem: 34. Find First and Last Position of Element in Sorted Array

**Difficulty**: Medium  
**Tags**: Binary Search, Array

### Description

Given an array of integers `nums` sorted in non-decreasing order, find the **starting** and **ending** position of a given `target` value.

If the target is not found in the array, return `[-1, -1]`.

You **must** write an algorithm with **O(log n)** runtime complexity.

---

### Examples

#### Example 1:

**Input:**  
`nums = [5,7,7,8,8,10]`, `target = 8`  
**Output:**  
`[3,4]`

#### Example 2:

**Input:**  
`nums = [5,7,7,8,8,10]`, `target = 6`  
**Output:**  
`[-1,-1]`

#### Example 3:

**Input:**  
`nums = []`, `target = 0`  
**Output:**  
`[-1,-1]`


## Brute Force Approach: Find First and Last Position of Element in Sorted Array

### 🔍 Approach
1. Initialize two variables `first` and `last` to `-1`.
2. Loop through the array from start to end.
3. If the current element equals the target:
   - If `first` is still `-1`, set it to the current index.
   - Always update `last` to the current index.
4. After the loop, return `[first, last]`.

---

### 🧠 Pseudocode

```
function searchRange(nums, target):
    first = -1
    last = -1
    for i from 0 to length of nums - 1:
        if nums[i] == target:
            if first == -1:
                first = i
            last = i

    return [first, last]
```
### ⏱ Time Complexity

- **O(n)**  
  You may need to scan every element in the array once.

### 🧮 Space Complexity

- **O(1)**  
  Only constant extra space is used (two integer variables: `first` and `last`).

---

## Optimal Binary Search Approach: Find First and Last Position of Element in Sorted Array

We use two binary searches to find the **first and last positions** of the target in a sorted array.

### 1️⃣ Find First Occurrence (Lower Bound)
- Use binary search to find the **first index** where `arr[i] >= target`.
- If target not found at this position, return `[-1, -1]`.

### 2️⃣ Find Last Occurrence (Upper Bound)
- Use binary search to find the **first index** where `arr[i] > target`.
- Subtract 1 from this index to get the **last occurrence**.

### ✅ Final Result
Return `[lower, upper - 1]`.

---

## 🧠 Edge Cases
- Empty array → `[-1, -1]`
- Target not found → `[-1, -1]`
- Target occurs once → same index for first and last
- Target at start/end → handled correctly


### 🧠 Pseudocode
```function searchRange(arr, target):
    if length of arr is 0:
        return [-1, -1]

    lower = length of arr
    upper = length of arr

    // Find lower bound (first occurrence of target)
    low = 0
    high = length of arr - 1

    while low <= high:
        mid = (low + high) / 2
        if arr[mid] >= target:
            lower = mid
            high = mid - 1
        else:
            low = mid + 1

    // If target not found, return [-1, -1]
    if lower == length of arr OR arr[lower] != target:
        return [-1, -1]

    // Find upper bound (just after last occurrence of target)
    low = 0
    high = length of arr - 1

    while low <= high:
        mid = (low + high) / 2
        if arr[mid] > target:
            upper = mid
            high = mid - 1
        else:
            low = mid + 1

    return [lower, upper - 1]
```
### 🕒 Time Complexity: `O(log n)`
- Two binary searches are used:
  - One for the **first occurrence** (lower bound).
  - One for the **last occurrence** (upper bound).
- Each binary search takes `O(log n)` time.
- Total time: `O(log n) + O(log n) = O(log n)`

---

### 🧠 Space Complexity: `O(1)`
- No extra data structures are used.
- Only a few variables (`low`, `high`, `mid`, etc.) are used.
- Space usage remains constant, regardless of input size.



