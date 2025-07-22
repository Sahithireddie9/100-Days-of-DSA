# Day 1: Maximum Sum Subarray of Size K

# Problem Statement: Maximum Sum Subarray of Size K

**Difficulty:** Easy  
**Pattern:** Sliding Window (Fixed Size)

---

## Description

Given an array of integers `arr` and an integer `k`, your task is to find the **maximum sum** of any contiguous subarray of size `k`.

This problem is a classic example of the **Sliding Window** technique, which helps reduce time complexity from O(n*k) to O(n) by avoiding unnecessary recalculations.

---

## Example

**Input:**  
`arr = [2, 1, 5, 1, 3, 2]`, `k = 3`  

**Output:**  
`9`

**Explanation:**  
- Subarrays of size 3 are:  
  `[2, 1, 5] → 8`  
  `[1, 5, 1] → 7`  
  `[5, 1, 3] → 9` 
  `[1, 3, 2] → 6`  
- The maximum sum is `9`.

---

## Constraints

- `1 <= k <= arr.length`
- `-10⁴ <= arr[i] <= 10⁴`

---

## Time Complexity

- **Naive approach (Brute Force):** O(n*k)  
- **Optimized Sliding Window:** O(n)


---

---

## Approach 1: Brute Force

### Intuition

The brute force approach involves checking **every possible subarray of size `k`**, calculating the sum of each, and keeping track of the maximum sum found.

While this approach is simple to understand, it is not efficient — especially for large arrays — because it does **redundant calculations** for overlapping windows.

---

### Pseudocode

```java
maxSum = 0
for i from 0 to n - k:
    currentSum = 0
    for j from i to i + k - 1:
        currentSum += arr[j]
    maxSum = max(maxSum, currentSum)
```
### ⏱️ Time Complexity

- The **outer loop** runs `(n - k + 1)` times  
- The **inner loop** runs `k` times for each window  
- So the **total time complexity** is:O(n * k)


---

## ⚡ Approach 2: Sliding Window (Optimal)

### 💡 Intuition

Instead of recalculating the sum of each subarray from scratch (as in the brute force method), we can use a **sliding window** of size `k`:

- Start by calculating the sum of the first `k` elements.
- Then slide the window one element at a time:
  - Subtract the element that's **leaving** the window.
  - Add the element that's **entering** the window.
- Update the `maxSum` at each step.

This avoids redundant work and brings the time complexity down to **O(n)**.

---

### 🧾 Pseudocode

```java
windowSum = sum of first k elements
maxSum = windowSum

for i from k to n - 1:
    windowSum = windowSum + arr[i] - arr[i - k]
    maxSum = max(maxSum, windowSum)

return maxSum
```

### Time Complexity
- We traverse the array only once, maintaining a running sum.

- Total time complexity:O(n)

---


