# Search a 2D Matrix
## Problem Statement

You are given an `m x n` integer matrix `matrix` with the following two properties:
1. Each row is sorted in non-decreasing order.  
2. The first integer of each row is greater than the last integer of the previous row.  
Given an integer `target`, return `true` if `target` is in `matrix` or `false` otherwise.  
You must write a solution in **O(log(m * n))** time complexity.
---
## Example 1
**Input:** matrix = [[1,3,5,7], [10,11,16,20], [23,30,34,60]], target = 3
**Output:** true

## Example 2
**Input:** matrix = [[1,3,5,7], [10,11,16,20], [23,30,34,60]], target = 13
**Output:** false

## Brute Force Approach

### Intuition
The simplest way to solve this problem is to **scan every element in the matrix** one by one.  
- Start from the first row, first column.  
- Check each element against the `target`.  
- If you find the target, return `true`.  
- If you reach the end of the matrix without finding it, return `false`.  

This approach does not use the sorted property of the matrix — it just performs a linear search across all elements.

---

### Pseudocode
```
function searchMatrix(matrix, target):
    for i from 0 to m-1:
        for j from 0 to n-1:
        if matrix[i][j] == target:
            return true
    return false
```


---

- **Time Complexity:** `O(m * n)`
- **Space Complexity:** `O(1)`

## Optimal Approach — Binary Search on a “Flattened” Matrix

### Intuition
Because:
1) each row is sorted, and  
2) the first element of each row is greater than the last of the previous row,  
the entire `m x n` matrix behaves like **one sorted 1D array** of length `m * n`.  
So we can run a single **binary search** over this conceptual array and map a 1D index back to `(row, col)`:

- For any index `k` in `[0, m*n - 1]`:
  - `row = k // n`
  - `col = k % n`

This lets us binary-search in **O(log(m*n))** without actually creating a new array.

---

### Pseudocode
```
    function searchMatrix(matrix, target):
        m = number of rows in matrix
        n = number of columns in matrix
        left = 0
        right = m * n - 1
        while left <= right:
            mid = left + (right - left) // 2
            row = mid // n
            col = mid % n
            value = matrix[row][col]

            if value == target:
                return true
            else if value < target:
                left = mid + 1
            else:
                right = mid - 1

    return false
```
- **Time Complexity:** `O(log(m * n))`
- **Space Complexity:** `O(1)`



