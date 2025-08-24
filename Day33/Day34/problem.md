

# Median of Two Sorted Arrays (O(log(m+n)))

## Problem Statement
You are given two **sorted** arrays `nums1` and `nums2` of sizes `m` and `n` respectively. Return the **median** of the combined multiset formed by all elements of `nums1` and `nums2`.

The solution should run in **O(log(m+n))** time.

- If the total number of elements is odd, the median is the **middle** element after merging.
- If even, the median is the **average of the two middle** elements after merging.

---

## Examples

### Example 1
**Input:** `nums1 = [1,3]`, `nums2 = [2]`  
**Output:** `2.00000`  
**Explanation:** Merged array is `[1,2,3]`, median is `2`.

### Example 2
**Input:** `nums1 = [1,2]`, `nums2 = [3,4]`  
**Output:** `2.50000`  
**Explanation:** Merged array is `[1,2,3,4]`, median is `(2+3)/2 = 2.5`.

---

## Constraints
- `nums1.length == m`  
- `nums2.length == n`  
- `0 <= m <= 1000`  
- `0 <= n <= 1000`  
- `1 <= m + n <= 2000`  
- `-10^6 <= nums1[i], nums2[i] <= 10^6`  
- Both arrays are individually sorted in non-decreasing order.

---

## Brute Force Approach

### Intuition
Merge the two arrays like the merge step of merge sort until we reach the middle. We don't need to store the entire merged array—just track the last one or two values needed to compute the median.

### Pseudocode
```
function medianBrute(nums1, nums2):
    m = length(nums1); n = length(nums2)
    total = m + n
    i = 0; j = 0
    prev = 0; curr = 0

    for k from 0 to total-1:
        prev = curr
        if i < m and (j >= n or nums1[i] <= nums2[j]):
            curr = nums1[i]; i += 1
        else:
            curr = nums2[j]; j += 1

        if k == total // 2:
            if total % 2 == 1:
                return curr
            else:
                return (prev + curr) / 2.0
```
### Time Complexity
- **O(m + n)** — single pass merge up to the middle.

### Space Complexity
- **O(1)** — no extra array required.

---

## Optimal Approach (Binary Search on Partitions)

### Intuition
Perform a binary search on the smaller array to find a partition such that:
- Left side contains the first `half = (m + n + 1) // 2` elements of the merged order.
- All elements in the left partitions are `<=` all elements in the right partitions.

Let `i` be the cut in `nums1` and `j = half - i` be the cut in `nums2`. We want:
```
maxLeft1 <= minRight2  AND  maxLeft2 <= minRight1
```
If not satisfied, move the binary search boundaries accordingly.

Once a correct partition is found:
- If `total` is odd: `median = max(maxLeft1, maxLeft2)`
- Else: `median = (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2`

Use sentinels (`-inf` and `+inf`) when the cut lands at array ends.

### Pseudocode
```
function findMedianSortedArrays(nums1, nums2):
    if length(nums1) > length(nums2):
        swap(nums1, nums2)  // ensure nums1 is the smaller array

    m = length(nums1); n = length(nums2)
    total = m + n
    half = (total + 1) // 2

    lo = 0
    hi = m

    while lo <= hi:
        i = (lo + hi) // 2        // cut in nums1
        j = half - i              // cut in nums2

        maxLeft1  = (-inf) if i == 0 else nums1[i-1]
        minRight1 = (+inf) if i == m else nums1[i]
        maxLeft2  = (-inf) if j == 0 else nums2[j-1]
        minRight2 = (+inf) if j == n else nums2[j]

        if maxLeft1 <= minRight2 and maxLeft2 <= minRight1:
            if total % 2 == 1:
                return max(maxLeft1, maxLeft2)
            else:
                leftMax  = max(maxLeft1, maxLeft2)
                rightMin = min(minRight1, minRight2)
                return (leftMax + rightMin) / 2.0
        elif maxLeft1 > minRight2:
            hi = i - 1             // move cut left
        else:
            lo = i + 1             // move cut right
```
### Time Complexity
- **O(log min(m, n))** — binary search over the smaller array.

### Space Complexity
- **O(1)** — constant extra space.

---

## Edge Cases
- One array empty → median is the median of the other array.
- All elements of one array are smaller than all elements of the other.
- Arrays with duplicates or negatives.
- Very unbalanced sizes (e.g., `m=0`, `n=1000`).

---

## Quick Reference

| Approach                         | Time Complexity         | Space Complexity |
|---------------------------------|-------------------------|------------------|
| Merge up to middle (Brute)      | O(m + n)                | O(1)             |
| Binary search on partitions     | O(log min(m, n))        | O(1)             |
