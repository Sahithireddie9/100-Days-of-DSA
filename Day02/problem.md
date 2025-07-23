# Day 2: Maximum Length Substring With Two Occurrences

---

## Problem Statement

You're given a string `s`.  
Your task is to return the **maximum length** of a substring such that **no character appears more than twice**.

---

## Examples

**Example 1:**

Input: `"bcbbbcba"`  
Output: `4`  
Explanation: Substrings like `"bcbb"` or `"bcba"` are valid. All characters occur at most twice.

**Example 2:**

Input: `"aaaa"`  
Output: `2`  
Explanation: Only two `'a'`s are allowed. So, `"aa"` is the longest valid substring.

---

## Approach 1: Brute Force (Reverse Search)

### Intuition

Instead of checking from short to long, I thought:  
**"What if I start with the full length and work backwards?"**

- I loop from the full length of the string down to 2
- For each length, I check **all substrings** of that size
- If any substring satisfies the rule (**no char appears more than twice**), I return that length immediately

###  Pseudocode (Brute Force)

```pseudo
for len from s.length down to 2:
    for start in 0 to (s.length - len):
        substring = s[start : start + len]
        if isValid(substring):
            return len

return 1

function isValid(substring):
    frequency = count characters
    if any character occurs > 2:
        return false
    return true
```

---


###  Time Complexity

- Outer loop: O(n)
- Inner loop: O(n)
- Frequency check: O(k) per substring

Overall: **O(n³)**  
But acceptable here since `n <= 100`.

---

## Approach 2: Sliding Window (Optimal)

### Intuition

I used the **Sliding Window** pattern for an efficient O(n) solution.

- I initialized two pointers: `left` and `right`  
- I expanded the window by moving `right` forward **as long as no character appears more than twice**  
- If a character occurs **more than twice**, I shrank the window from the left until the window was valid again  
- Throughout, I updated the `maxWindowSize` every time the window was valid

This keeps the substring valid at all times and ensures we find the longest one possible.

### Pseudocode


````Initialize left = 0, right = 0
Initialize count[26] = {0}
Initialize maxWindow = 0

while right < s.length:
charIndex = s[right] - 'a'
if count[charIndex] < 2:
count[charIndex]++
update maxWindow = max(maxWindow, right - left + 1)
right++
else:
count[s[left] - 'a']--
left++

return maxWindow




###  Time Complexity

- Each character is visited at most twice: once by `right`, once by `left`
- So it's a clean **O(n)** time solution  
- Constant space (just a 26-sized array for lowercase letters)

---

