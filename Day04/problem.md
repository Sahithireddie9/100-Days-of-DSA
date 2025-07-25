#  Day 4: First Negative Integer in Every Window of Size K

## Problem Statement

Given an array `arr[]` and a positive integer `k`, find the **first negative integer** for every contiguous subarray (or window) of size `k`.

If a window does **not contain** a negative integer, return **0** for that window.

---

##  Examples

### Example 1
Input: arr[] = [-8, 2, 3, -6, 10], k = 2
Output: [-8, 0, -6, -6]


### Example 2
Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
Output: [-1, -1, -7, -15, -15, 0]


### Example 3
Input: arr[] = [12, 1, 3, 5], k = 3
Output: [0, 0]


---

##  Brute Force Approach

###  Intuition

- Slide a window of size `k` over the array.
- For each window, check all `k` elements from left to right.
- The **first negative** number found in that window is the answer for that window.
- If no negative number is found, return `0`.

---

###  Pseudocode

```pseudo
result = []

for i = 0 to n - k:
    found = false
    for j = i to i + k - 1:
        if arr[j] < 0:
            result.add(arr[j])
            found = true
            break
    if not found:
        result.add(0)
```
###  Time Complexity: O(n * k)
Each of the (n - k + 1) windows takes O(k) time to scan.

###  Space Complexity: O(1)
Ignoring the output list, no extra space is used.

##  Optimal Approach (Sliding Window + Queue)

###  Intuition

- Use a deque to store the indexes of negative numbers within the current window.
- While sliding the window:
  - If a new number is negative, add its index to the deque.
  - If the leftmost index in the deque is outside the current window, remove it.
  - The first negative number for the window is the value at the front of the deque (if exists), else `0`.

---

### Pseudocode
```Initialize empty deque dq
Initialize empty result list
start = 0

for end = 0 to n - 1:
    if arr[end] < 0:
    dq.push_back(end)
    if end - start + 1 == k:  
        if dq is not empty:  
            result.add(arr[dq.front()])  
        else:  
            result.add(0)  

        if dq.front() == start:  
            dq.pop_front()  

        start++
```

### Time Complexity:O(n)

Each element is added and removed from the deque at most once.

---

### Space Complexity:O(k)

At most `k` indices stored in the deque at any time.





