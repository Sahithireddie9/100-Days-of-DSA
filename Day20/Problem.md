#  Subarray Sum Equals K

## Problem Statement

Given an array of integers `nums` and an integer `k`, return the **total number of subarrays** whose sum equals to `k`.

A **subarray** is a contiguous, non-empty sequence of elements within an array.

---

### Example 1

**Input:**  
`nums = [1, 1, 1]`, `k = 2`  
**Output:**  
`2`

---

### Example 2

**Input:**  
`nums = [1, 2, 3]`, `k = 3`  
**Output:**  
`2`

---

### Constraints

- `1 <= nums.length <= 2 * 10^4`
- `-1000 <= nums[i] <= 1000`
- `-10^7 <= k <= 10^7`


# Brute Force Solution

## 1) Naive Brute Force (O(n³))
Recompute the sum for every subarray `(i..j)` from scratch.

### Idea
- Pick every start index `i`.
- For every end index `j >= i`, compute `sum(nums[i..j])` by looping again.
- If the sum equals `k`, increment the count.

### Pseudocode
```
function subarraySumNaive(nums, k):
    n = length(nums)
    count = 0
    for i from 0 to n-1:
        for j from i to n-1:
            curr = 0
            for t from i to j:
                curr = curr + nums[t]
            if curr == k:
                count = count + 1
    return count
```
### Complexity
- **Time:** O(n³) — three nested loops.
- **Space:** O(1) — constant extra space.


---

## 2) Improved Brute Force (O(n²))
Accumulate the running sum for each fixed start `i` so you don’t rescan the same elements.

### Idea
- Fix `i`.
- Grow `j` from `i` to `n-1`, maintaining a running sum `curr += nums[j]`.
- Compare `curr` with `k` at each step.

### Pseudocode
```
function subarraySumQuadratic(nums, k):
    n = length(nums)
    count = 0
    for i from 0 to n-1:
        curr = 0
        for j from i to n-1:
            curr = curr + nums[j]
            if curr == k:
                count = count + 1
    return count
```
### Complexity
- **Time:** O(n²) — two nested loops.
- **Space:** O(1) — constant extra space.


## Optimal Solution — Prefix Sum + HashMap (O(n) Time)

### Approach
- Use a **prefix sum** to track the cumulative sum up to the current index.
- Maintain a **HashMap** (`freq`) where:
  - **Key** = prefix sum value.
  - **Value** = how many times this prefix sum has occurred so far.
- For each element:
  1. Add it to the running prefix sum `presum`.
  2. Check if `(presum - k)` exists in `freq`.  
     - If yes, it means there are `freq[presum - k]` subarrays ending at the current index with sum = `k`.
     - Add this count to the total answer.
  3. Record the current `presum` in `freq`, incrementing its count.

**Why it works:**  
If `presum[j] - presum[i] == k`, then the subarray `(i, j]` has sum `k`.  
The map allows constant-time lookup for how many such `presum[i]` exist for the current `presum[j]`.

---

### Pseudocode
```
function subarraySum(nums, k):
    freq = new HashMap()
    freq.put(0, 1)         // base case: empty prefix
    presum = 0
    count = 0

    for x in nums:
        presum = presum + x
        if freq contains (presum - k):
            count = count + freq.get(presum - k)
        freq.put(presum, freq.getOrDefault(presum, 0) + 1)

    return count
```
### Complexity
- **Time:** O(n) — Single pass through the array, constant-time map operations.
- **Space:** O(n) — For storing prefix sum frequencies in the HashMap.


