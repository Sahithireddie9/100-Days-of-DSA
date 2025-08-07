# Problem: Merge Intervals (LeetCode 56)

## Problem Statement

Given an array of intervals where `intervals[i] = [start_i, end_i]`, **merge all overlapping intervals**, and return an array of the non-overlapping intervals that **cover all the intervals** in the input.

## Conditions

- Two intervals `[a, b]` and `[c, d]` overlap **if and only if** `b >= c`.
- You must return only the **merged, non-overlapping intervals**.
- The resulting intervals must be returned in sorted order by start time.

---

## 🔍 Examples

### Example 1:
**Input:**  intervals = [[1,3],[2,6],[8,10],[15,18]]
**Output:**  [[1,6],[8,10],[15,18]]


**Explanation:**  
- Intervals [1,3] and [2,6] overlap, so we merge them into [1,6].

---

### Example 2:
**Input:**  intervals = [[1,4],[4,5]]
**Output:**  [[1,5]]


**Explanation:**  
- Intervals [1,4] and [4,5] are considered overlapping.

---

## Constraints

- `1 <= intervals.length <= 10⁴`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10⁴`

---

## Optimal Approach

### Intuition:
1. **Sort** the intervals by their starting times.
2. Iterate through each interval:
   - If the current interval **does not overlap**, add it to the result.
   - If it **overlaps**, merge it with the previous interval by updating the end time.

---

### Pseudocode:
```text
sort intervals by start time
initialize empty result list

for each interval in intervals:
    if result is empty OR last interval in result doesn't overlap:
        add interval to result
    else:
        merge current interval with last by updating end time

return result
```


## Time Complexity:
- O(n log n) → for sorting the intervals
- O(n) → for merging

## Total: O(n log n)

## Space Complexity:
- O(n) → for the output list


