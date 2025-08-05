# Day 15: Container With Most Water

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `iᵗʰ` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container holds the **most water**.

**Return the maximum amount of water a container can store.**

**Note:** You may not slant the container.

---

## Examples

### Example 1:
**Input:** `height = [1,8,6,2,5,4,8,3,7]`  
**Output:** `49`  
**Explanation:** The container formed between lines at index 1 and 8 holds the most water: `min(8, 7) * (8 - 1) = 7 * 7 = 49`.

---

### Example 2:
**Input:** `height = [1,1]`  
**Output:** `1`  
**Explanation:** Only one possible container of width 1 and height 1.

---

## Brute Force Approach

### Intuition:
Try **every pair of lines** and compute the area they form. Track the **maximum area** found.

### Pseudocode:
```text
maxArea = 0
for i from 0 to n-1:
    for j from i+1 to n-1:
        height = min(height[i], height[j])
        width = j - i
        area = height * width
        maxArea = max(maxArea, area)
return maxArea
```
## ⏱ Time & Space Complexities

### Brute Force Approach
- **Time Complexity:** O(n²) — for checking all line pairs
- **Space Complexity:** O(1) — no extra space used

---

## Optimal Approach – Two Pointers

### Intuition:
Use two pointers starting at both ends of the array.

- Calculate the area between the pointers
- Move the pointer pointing to the shorter line inward
- Why? Because a taller line might result in a larger area

---

### Pseudocode:
```text
left = 0
right = n - 1
maxArea = 0

while left < right:
    height = min(height[left], height[right])
    width = right - left
    area = height * width
    maxArea = max(maxArea, area)

    if height[left] < height[right]:
        left++
    else:
        right--

return maxArea
```
## Time Complexity:
- O(n) — each element is visited at most once

## Space Complexity:
- (1) — only constant space is used
