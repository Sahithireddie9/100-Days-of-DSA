# Day 5: Longest Substring Without Repeating Characters

## Problem Statement

Given a string `s`, find the length of the **longest substring** without **repeating characters**.

---

## Example Test Cases

**Example 1:**
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

**Example 2:**
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b".

**Example 3:**
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

---

## Brute Force Approach

### Intuition

Start at every character and try to build the longest substring without any duplicates by checking each character one by one. If a duplicate is found, stop and start again from the next character.

---

### Pseudocode

maxWindow = 0

for i from 0 to length of s:
create new frequency array[256]

for j from i to end of string:
    if character at j is already in frequency array:
        break
    else:
        update maxWindow = max(maxWindow, j - i + 1)
        mark character at j as seen


---

### Time Complexity

- **O(n²)**  
  For each character, we  scan the rest of the string.

### Space Complexity

- **O(1)**  
  Fixed 256-size array for ASCII character tracking.

---

## Optimal Approach (Sliding Window + Frequency Array)

### Intuition

Use a sliding window technique with two pointers.  
Expand the window by moving the right pointer until a duplicate is found.  
Then, shrink it from the left until the window is valid again (i.e., no duplicates).  
This way, each character is visited at most twice.

---

### Pseudocode

left = 0, right = 0, windowSize = 0
initialize count array of size 256

while right < s.length:
index = s.charAt(right)

if count[index] == 0:
    mark character as seen
    update windowSize
    right++
else:
    unmark character at left
    left++

---

### Time Complexity

- **O(n)**  
  Each character is added and removed from the window at most once.

### Space Complexity

- **O(1)**  
  Array size is constant (256 ASCII characters).

---


