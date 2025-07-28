# Day 7: Minimum Window Substring

## Problem Statement

Given two strings `s` and `t`, return the **minimum window substring** of `s` such that every character in `t` (including duplicates) is included in the window.  
If there is no such substring, return the empty string `""`.

The answer is guaranteed to be unique.

---

## Examples

### Example 1:
**Input:**  
s = `"ADOBECODEBANC"`  
t = `"ABC"`  
**Output:** `"BANC"`

### Example 2:
**Input:**  
s = `"a"`  
t = `"a"`  
**Output:** `"a"`

### Example 3:
**Input:**  
s = `"a"`  
t = `"aa"`  
**Output:** `""`

---

## Brute Force Approach

### Intuition:
- Generate **all substrings** of `s`.
- For each one, check whether it **contains all characters of `t` (with correct frequencies)**.
- Track the shortest valid substring.

### Pseudocode:
minLen = ∞
result = ""

For i = 0 to s.length - 1:
    For j = i + 1 to s.length:
    substring = s[i to j]
    If substring contains all chars from t (with count):
        If substring.length < minLen:
            minLen = substring.length
            result = substring

Return result


### Time Complexity:
- Generating all substrings: O(n²)  
- For each substring, checking counts: O(n)  
- **Total: O(n³)**

### Space Complexity:
- O(1) (using fixed-size frequency arrays)

---

## Optimal Approach (Sliding Window + Frequency Map)

### Intuition:
- Use a **frequency array** to count characters in `t`.
- Slide a window using two pointers (`left`, `right`) across `s`.
- For each character in the window:
  - Decrease its count in the freq map.
  - If it’s part of `t`, decrement the `required` count.
- When all characters are matched (`required == 0`), try **shrinking the window** from the left.
- Keep track of the **smallest valid window**.

### Pseudocode:
1. Initialize a frequency map 'freq[128]' to count characters in t
2. Initialize:
      - required = number of characters to match (t.length)
      - left = 0, right = 0 (sliding window pointers)
      - minLen = ∞, startIndex = -1 (to track smallest window)

3. For each character 'c' in t:
      - freq[c] += 1

4. While right < s.length:
      a. freq[s[right]] -= 1
      b. If freq[s[right]] ≥ 0:
            required -= 1

      c. While required == 0:
            i. If (right - left + 1) < minLen:
                  - minLen = right - left + 1
                  - startIndex = left

            ii. freq[s[left]] += 1
            iii. If freq[s[left]] > 0:
                     required += 1

            iv. left += 1

      d. right += 1

5. If minLen == ∞:
      return ""

6. Else:
      return substring from startIndex to startIndex + minLen


---

### Time Complexity:
- **O(n + m)**, where `n = s.length`, `m = t.length`  
  Each character is visited at most twice.

### Space Complexity:
- **O(1)** – Using a fixed-size ASCII array of size 128

---
