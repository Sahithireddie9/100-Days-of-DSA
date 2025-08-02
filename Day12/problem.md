# Day 12 - Valid Palindrome

## Problem Statement

A string is a **palindrome** if, after converting all uppercase letters into lowercase and removing all non-alphanumeric characters, it reads the same forward and backward.

### Constraints:
- 1 <= s.length <= 2 * 10⁵  
- `s` consists only of printable ASCII characters.

---

## Examples

### Example 1:
**Input:**  
`s = "A man, a plan, a canal: Panama"`  
**Output:** `true`  
**Explanation:** `"amanaplanacanalpanama"` is a palindrome.

### Example 2:
**Input:**  
`s = "race a car"`  
**Output:** `false`  
**Explanation:** `"raceacar"` is not a palindrome.

### Example 3:
**Input:**  
`s = " "`  
**Output:** `true`  
**Explanation:** Empty strings are considered valid palindromes.

---

## Brute Force Approach

### Intuition:
Loop through the string and pick only **alphanumeric** characters. Convert them to lowercase and build a clean version of the string. Then, check if this cleaned string is a palindrome by comparing it to its reverse.

### Pseudocode:
```text
cleaned = ""

for char in s:
    if char is alphanumeric:
        cleaned += lowercase(char)

return cleaned == reverse(cleaned)
```
## Time Complexity:
`O(n)` for filtering and reversing the string

## Space Complexity:
`O(n)` to store the cleaned string

---

## Optimal Approach – Two Pointers

### Intuition:
Instead of creating a new filtered string (which uses extra space), we can:

Use two pointers: one starting from the beginning (left) and one from the end (right).

Skip any character that is not alphanumeric.

Compare the characters at both ends (after converting to lowercase).

If all matching characters are equal while moving inward, the string is a palindrome.

This way, we avoid extra space and improve performance.

---

### Pseudocode:
```text
left = 0  
right = s.length - 1

while left <= right:
    if s[left] is not alphanumeric:
        left++
    else if s[right] is not alphanumeric:
        right--
    else:
        if lowercase(s[left]) != lowercase(s[right]):
            return false
        left++
        right--

return true
```

## Time Complexity:
O(n) → Each character is visited at most once.

## Space Complexity:
O(1) → No extra space is used (just two pointers).