
# Row With Maximum Number of 1s (First Such Row)

## Problem Statement
You are given a 2D binary array `arr` of shape `n x m` that contains only `0`s and `1`s. Each row of the array is **sorted in non-decreasing order** (i.e., all the `0`s come before the `1`s in every row). Your task is to return the **index of the first row** (0-based) that contains the **maximum number of `1`s**. If **no** row contains any `1`, return `-1`.

- Use 0-based indexing.
- If multiple rows have the same maximum number of `1`s, return the **smallest row index** among them.

---

## Examples

### Example 1
**Input:** `arr = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]`  
**Output:** `2`  
**Explanation:** Row 2 has four `1`s, which is the maximum. Return `2`.

### Example 2
**Input:** `arr = [[0,0], [1,1]]`  
**Output:** `1`  
**Explanation:** Row 1 has two `1`s, which is the maximum. Return `1`.

### Example 3
**Input:** `arr = [[0,0], [0,0]]`  
**Output:** `-1`  
**Explanation:** There are no `1`s in any row. Return `-1`.

---

## Constraints
- `1 <= n, m`
- Rows are sorted in non-decreasing order.
- Elements are either `0` or `1`.

---

## Brute Force Approach

### Intuition
Count the number of `1`s in every row and track the row with the largest count. Because rows are sorted, you could simply sum the row (since elements are 0/1). If there’s a tie, keep the **smallest index** encountered first.

### Pseudocode
```
function rowWithMaxOnes_bruteforce(arr):
    n = number of rows in arr
    m = number of columns in arr
    best_row = -1
    best_count = 0

    for i from 0 to n-1:
        count_ones = 0
        for j from 0 to m-1:
            if arr[i][j] == 1:
                count_ones = count_ones + 1

        if count_ones > best_count:
            best_count = count_ones
            best_row = i

    if best_count == 0:
        return -1
    return best_row
```

### Time Complexity
- **O(n·m)** — we scan every cell.

### Space Complexity
- **O(1)** — constant extra space.

> Minor improvement: because each row is sorted, you could find the first `1` per row via linear scan from left to right and break early—but worst case remains **O(n·m)**.

---

## Better Approach (Per-Row Binary Search)

### Intuition
Since each row is sorted (`0`s then `1`s), the index of the **first `1`** in a row lets us compute the number of `1`s as `m - first_one_index`. Use **binary search** on each row to find the first `1`. Track the row with the maximum number of `1`s (breaking ties by smaller index).

### Pseudocode
```
function firstOneIndex(row):  // binary search
    lo = 0
    hi = length(row) - 1
    ans = length(row)  // default means "no 1s"
    while lo <= hi:
        mid = (lo + hi) // 2
        if row[mid] == 1:
            ans = mid
            hi = mid - 1
        else:
            lo = mid + 1
    return ans  // in [0..m] ; m means no 1s

function rowWithMaxOnes_binarySearch(arr):
    n = number of rows
    m = number of columns
    best_row = -1
    best_count = 0

    for i from 0 to n-1:
        idx = firstOneIndex(arr[i])
        count_ones = m - idx
        if count_ones > best_count:
            best_count = count_ones
            best_row = i

    if best_count == 0:
        return -1
    return best_row
```

### Time Complexity
- **O(n · log m)** — binary search in each of `n` rows.

### Space Complexity
- **O(1)** — constant extra space.

---

## Optimal Approach (Top-Right Walk)

### Intuition
Exploit the row-sorted property to do a **single pass** from the **top-right** corner:
- Start at `r = 0, c = m-1`.
- If `arr[r][c] == 1`: move **left** (`c -= 1`) and update the best row—moving left increases the count of `1`s in the current row.
- Else (`0`): move **down** (`r += 1`) to find a row that may have more `1`s.
- Continue while `r < n` and `c >= 0`.

This guarantees we visit at most `n + m` cells.

Tie-breaking: if we only update `best_row` when we **strictly** increase `best_count`, the earliest row index is naturally preserved.

### Pseudocode
```
function rowWithMaxOnes_topRight(arr):
    n = number of rows
    m = number of columns
    r = 0
    c = m - 1
    best_row = -1
    best_count = 0

    while r < n and c >= 0:
        if arr[r][c] == 1:
            // number of 1s in current row if first 1 is at column c
            // but as we move leftwards, count will increase by 1 each step
            best_row = r
            best_count = m - c
            c = c - 1       // move left to try to find an earlier 1
        else:
            r = r + 1       // move down to a row that might have more 1s

    if best_count == 0:
        // Optionally confirm: check if any row had 1s;
        // but if we never saw a 1, best_row stayed -1.
        return -1
    return best_row
```

### Correctness Notes
- Moving left on a `1` *stays in the same row* and can only **increase** that row’s 1-count estimate.
- Moving down on a `0` *skips rows* that cannot beat the current row at that column, due to sorting.
- We always keep the earliest row that achieves the current highest count, since we only update on a strict improvement.

### Time Complexity
- **O(n + m)** — each step moves one cell left or down, never revisiting cells.

### Space Complexity
- **O(1)** — constant extra space.

---

## Edge Cases to Consider
- All zeros → return `-1`.
- All ones → return `0` (first row has the maximum).
- Single row or single column.
- Multiple rows with the same maximum count → return the **smallest** index.
- Empty matrix (if allowed by problem) → return `-1`.

---

## Quick Reference

| Approach                    | Time Complexity | Space Complexity |
|----------------------------|-----------------|------------------|
| Brute Force (count each)   | O(n·m)          | O(1)             |
| Per-Row Binary Search      | O(n·log m)      | O(1)             |
| Top-Right Walk (Optimal)   | O(n + m)        | O(1)             |

---

