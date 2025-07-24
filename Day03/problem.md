# Day 3: Maximum of All Subarrays of Size K

---

## Problem Statement

Given an integer array `arr` and an integer `k`, return a list containing the **maximum element of every subarray of size `k`**.

This is a classic **sliding window maximum** problem where we shift a window of size `k` across the array and record the max from each position.

---

## Examples

**Example 1:**

Input: `arr = [1, 3, -1, -3, 5, 3, 6, 7]`, `k = 3`  
Output: `[3, 3, 5, 5, 6, 7]`

**Example 2:**

Input: `arr = [4, 2, 12, 3, -1, 0, 5]`, `k = 2`  
Output: `[4, 12, 12, 3, 0, 5]`

---

## Brute Force Approach

### Intuition

I started simple:  
- For every subarray of size `k`, I loop through and find the maximum value manually.  
- I store that max in the result and move the window one step forward.

This method is straightforward but not very efficient for large arrays because it repeats a lot of work.

---

### Pseudocode

```pseudo
result = []

for i in 0 to (n - k):
    maxVal = arr[i]
    for j in i to (i + k - 1):
        if arr[j] > maxVal:
            maxVal = arr[j]
    result.add(maxVal)

return result
```
### Time Complexity

- Each window takes **O(k)** time to find the maximum.
- There are approximately **(n - k + 1)** windows.

So the overall time complexity is:O(n * k)

## Optimal Approach (Sliding Window + Deque)

### Intuition

To optimize this, I used a **deque (double-ended queue)** to keep track of potential max elements.

- The deque stores **indexes**, not values.
- It always keeps the **largest element's index at the front**.
- If a smaller value comes in, we remove all smaller elements from the back — they’ll never be the max again.
- If the front of the deque falls out of the current window, we remove it.
- Once the first window is full (`i >= k - 1`), we start collecting max values from the front of the deque.

---

### Pseudocode

```pseudo
Initialize deque dq
Initialize result list

for i in 0 to n - 1:
    // Remove indexes outside the window
    if dq.front() == i - k:
        dq.pop_front()

    // Remove smaller values from the back
    while dq not empty and arr[i] >= arr[dq.back()]:
        dq.pop_back()

    dq.push_back(i)

    // Window ready → store result
    if i >= k - 1:
        result.add(arr[dq.front()])
```

### Time Complexity

- Each element is added and removed from the deque at most once.
- So the overall time complexity is:O(n)
---

### space Complexity

- The deque holds at most `k` elements at any time.
- The result list holds `n - k + 1` elements.
- So the space complexity is:O(K)




