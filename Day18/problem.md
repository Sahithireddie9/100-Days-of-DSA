# 57. Insert Interval

You are given an array of **non-overlapping** intervals `intervals` where `intervals[i] = [start_i, end_i]` represents the start and end of the *i*-th interval, and `intervals` is **sorted in ascending order by** `start_i`.  
You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.

Insert `newInterval` into `intervals` so that the array remains sorted by start time **and** contains **no overlapping intervals** (merge overlaps if necessary).

Return the resulting array of intervals.  
You **do not** need to modify the input array in place.

---

## Examples

**Example 1**
Input: intervals = [[1,3],[6,9]]
newInterval = [2,5]
Output: [[1,5],[6,9]]


**Example 2**
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: [4,8] overlaps with [3,5], [6,7], and [8,10], so they merge into [3,10].

---

## Constraints
- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10^5`
- `intervals` is **sorted** by `start_i` in ascending order
- `newInterval.length == 2`
- `0 <= start <= end <= 10^5`

---

## Approach

We exploit that `intervals` are **sorted** and **non-overlapping**. We do one linear pass and consider three regions:

1. **Left (no overlap):** All intervals that **end before** `newInterval` starts — copy them directly.
2. **Overlap (merge):** While intervals **overlap** `newInterval` (i.e., `interval.start <= newEnd`), expand `newInterval` to the merged span:
   - `newStart = min(newStart, interval.start)`
   - `newEnd   = max(newEnd, interval.end)`
3. **Right (no overlap):** All remaining intervals (start **after** `newInterval` ends) — copy them directly.

Finally, place the merged `newInterval` between the left and right parts. This preserves sorted order and eliminates overlaps in **O(n)** time.

---

## Pseudocode
```
function insertInterval(intervals, newInterval):
    result = empty list
    i = 0
    n = length(intervals)
    start = newInterval[0]
    end   = newInterval[1]

    # Step 1: Add all intervals that end before the new interval starts
    while i < n AND intervals[i][1] < start:
        result.append(intervals[i])
        i = i + 1

    # Step 2: Merge all overlapping intervals with the new interval
    while i < n AND intervals[i][0] <= end:
        start = min(start, intervals[i][0])
        end   = max(end,   intervals[i][1])
        i = i + 1

    # Add the merged interval
    result.append([start, end])

    # Step 3: Add all remaining intervals
    while i < n:
        result.append(intervals[i])
        i = i + 1

    return result
```

---

## Time & Space Complexity

- **Time Complexity:** `O(n)`  
  Single pass through the `intervals` array.
- **Space Complexity:** `O(n)`  
  For the output list of intervals (required by the problem; auxiliary overhead is `O(1)`).

---

## Edge Cases to Verify

- `intervals` is empty → result is `[newInterval]`.
- `newInterval` comes **before** all intervals (e.g., ends before first starts).
- `newInterval` comes **after** all intervals (e.g., starts after last ends).
- `newInterval` overlaps **multiple** consecutive intervals.
- `newInterval` already fits **exactly** between two intervals without overlap.


