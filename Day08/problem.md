# Day 08 – Two Sum II (Two Pointer Approach)

## Problem Statement

You're given a **sorted array** of integers and a target sum.Find **two numbers** in the array that **add up to the target**. Then return their **1-based indices** (index starts from 1, not 0).There's always exactly **one solution**, and you **can’t use the same element twice**.
---

## Examples

### Example 1
**Input:**  
`numbers = [2, 7, 11, 15]`, `target = 9`  
**Output:**  
`[1, 2]`  
**Explanation:**  
`2 + 7 = 9`, so we return their positions as `[1, 2]`.

### Example 2
**Input:**  
`numbers = [2, 3, 4]`, `target = 6`  
**Output:**  
`[1, 3]`  
**Explanation:**  
`2 + 4 = 6` → `[1, 3]`.

### Example 3
**Input:**  
`numbers = [-1, 0]`, `target = -1`  
**Output:**  
`[1, 2]`  
**Explanation:**  
`-1 + 0 = -1` → `[1, 2]`.

---

## Constraints
- Array is sorted in **non-decreasing** order.
- Use **constant space**.
- 2 ≤ numbers.length ≤ 30,000  
- -1000 ≤ numbers[i], target ≤ 1000  
- **Exactly one solution will always exist.**

---

## Brute Force Approach

### Intuition:
Just try **every possible pair** of numbers and check if they add up to the target.

### Pseudocode:
```text
for i from 0 to n-1:
    for j from i+1 to n-1:
        if numbers[i] + numbers[j] == target:
            return [i+1, j+1]
```

### Time Complexity:O(n^2) → Too slow for large inputs.

### Space Complexity:O(1) → No extra storage used.

---

### Optimal Approach – Two Pointers

#### Intuition:
Since the array is already sorted, we can use two pointers:

- `left` starts at the beginning  
- `right` starts at the end  

We calculate the sum:

- If it equals the target → return the indices  
- If it's less → move `left` pointer forward  
- If it's more → move `right` pointer backward  

#### Pseudocode:
```text
left = 0
right = n - 1

while left < right:
    sum = numbers[left] + numbers[right]
    
    if sum == target:
        return [left + 1, right + 1]
    else if sum < target:
        left++
    else:
        right--
```

### Time Complexity:
O(n) → Each element is visited at most once.

### Space Complexity:
O(1) → No extra space used.

