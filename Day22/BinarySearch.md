## What is Binary Search?
Binary Search is an efficient algorithm for finding a target value within a **sorted** array.  
It works by repeatedly dividing the search interval in half until the target is found or the interval is empty.

---

## Intuition
Imagine looking for a word in a dictionary:  
- You open the book in the middle.  
- If the word comes before your page, you search the left half.  
- If it comes after, you search the right half.  
- Repeat until you find the word or confirm it isn’t there.

Binary Search applies this idea to **sorted arrays** — every comparison halves the possible search space.

---

## Approach
1. Start with two pointers: **left** at the start, **right** at the end.
2. Find the middle index:  
   `mid = left + (right - left) / 2` (this prevents integer overflow).
3. Compare:
   - If `arr[mid] == target`, return `mid`.
   - If `arr[mid] < target`, search the right half (`left = mid + 1`).
   - If `arr[mid] > target`, search the left half (`right = mid - 1`).
4. Repeat until `left > right` (target not found).

---

## Pseudocode (Iterative)
```
function binarySearch(arr, target):
    left = 0
    right = length(arr) - 1

    while left <= right:
        mid = left + (right - left) // 2

        if arr[mid] == target:
            return mid
        else if arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1
```

---

## Pseudocode (Recursive)
```
function binarySearchRecursive(arr, left, right, target):
    if left > right:
        return -1

    mid = left + (right - left) // 2

    if arr[mid] == target:
        return mid
    else if arr[mid] < target:
        return binarySearchRecursive(arr, mid + 1, right, target)
    else:
        return binarySearchRecursive(arr, left, mid - 1, target)
```

---

## Time Complexity
- **O(log n)** — because the search space is halved each step.

## Space Complexity
- Iterative: **O(1)** (only a few variables used)
- Recursive: **O(log n)** (due to function call stack)
