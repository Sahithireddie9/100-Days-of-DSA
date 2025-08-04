# Problem 3Sum

## Description

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that:

- `i != j`, `i != k`, and `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

**Note:** The solution set must not contain duplicate triplets.

---

## Constraints

- 3 ≤ `nums.length` ≤ 3000  
- -10⁵ ≤ `nums[i]` ≤ 10⁵

---

## Examples

### Example 1
Input: nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1, -1, 2], [-1, 0, 1]]
**Explanation:**
- (-1) + 0 + 1 = 0  
- (-1) + (-1) + 2 = 0  
- Only distinct triplets are returned.

---

### Example 2
Input: nums = [0, 1, 1]
Output: []
**Explanation:**  
No valid triplet exists that sums to 0.

---

### Example 3
Input: nums = [0, 0, 0]
Output: [[0, 0, 0]]
**Explanation:**  
Only one valid triplet: 0 + 0 + 0 = 0

---

---

## Brute Force Intuition

To solve the problem naively, we can try **every combination of 3 different numbers** in the array and check if their sum is 0.

Since we're checking all triplets:
- We use **three nested loops** to explore every possible combination.
- To avoid returning duplicate triplets, we:
  - Sort each valid triplet before storing it.
  - Use a `Set<List<Integer>>` to store only **unique** sorted triplets.

This approach guarantees correctness but is **inefficient for large arrays** due to its cubic time complexity.

---

## Brute Force Pseudocode
```
initialize an empty set called uniqueTriplets
n = length of nums
for i from 0 to n-1:
    for j from i+1 to n-1:
        for k from j+1 to n-1:
            if nums[i] + nums[j] + nums[k] == 0:
                triplet = [nums[i], nums[j], nums[k]]
                sort(triplet)
                add triplet to uniqueTriplets
return list version of uniqueTriplets
```

##  Time Complexity (Brute Force)

- The three nested loops give us **O(n³)** combinations.
- For each valid triplet:
  - Sorting a list of 3 elements takes **O(1)** (constant time)
  - Inserting into a HashSet is **O(1)** average time
- Therefore, the total time complexity is:  
  **O(n³)**

> This approach is not efficient for `n > 300`

---

## Space Complexity (Brute Force)

- The only extra space used is:
  - A **Set** of unique triplets.
  - In the worst case (many valid triplets), this is **O(k)** where `k` is the number of valid unique triplets.
- No other significant space is used.

Therefore:
**Space Complexity: O(k)**

---


---

## Better Solution Intuition (HashSet-Based Two-Sum Trick)

Instead of using three nested loops, we can fix one number and use a **HashSet** to find the other two numbers that sum up to zero.

### Simple Explanation:
- 1.Fix one element (nums[i]) in the outer loop.
- 2.For the remaining array (j = i+1 to end), you're now looking for two numbers (nums[j] and k) such that:
```
nums[i] + nums[j] + k == 0
=> k = -(nums[i] + nums[j])
```
- 3.So you maintain a HashSet set to track previously seen elements while traversing j.
- 4.If the complement k is found in the set, you've discovered a triplet:[nums[i], nums[j], k]
- 5.Sort the triplet and add it to a result Set<List<Integer>> to ensure uniqueness.

- It reduces the time from **O(n³)** to **O(n²)**.

---

## Optimal Solution Intuition (Two-Pointer Technique After Sorting)

Instead of using a set with a two-sum helper, we can solve the problem more efficiently using a **two-pointer** approach after sorting the array.

### Simple Intuition:

1. **Sort the array** first to bring all similar numbers together and enable two-pointer logic.
2. Fix one number `nums[i]` in a loop.
3. Use two pointers:
   - `left = i + 1`
   - `right = nums.length - 1`
4. Calculate the sum of the triplet:sum = nums[i] + nums[left] + nums[right]
5. If the sum is zero, store the triplet.
6. If the sum is too small, move `left++` to increase it.
7. If the sum is too big, move `right--` to decrease it.
8. Use a `Set<List<Integer>>` to automatically eliminate duplicates.

---

## Pseudocode
```
function threeSum(nums):
    if nums is null or has less than 3 elements:
        return empty list
    sort(nums)
    resultSet = empty set

    for i = 0 to nums.length - 2:
        left = i + 1
        right = nums.length - 1

        while left < right:
            sum = nums[i] + nums[left] + nums[right]

            if sum == 0:
                add sorted triplet [nums[i], nums[left], nums[right]] to resultSet
                left++
                right--
            else if sum < 0:
                left++
            else:
                right--

    return resultSet converted to list
```  

---

## Time Complexity

| Step                  | Complexity        |
|-----------------------|-------------------|
| Sorting the array     | O(n log n)        |
| Outer loop (i)        | O(n)              |
| Inner two-pointer loop| O(n) (per i)      |
| **Total**             | **O(n²)**         |

> Sorting takes O(n log n), and the main loop with two pointers takes O(n²) in total.

---

## Space Complexity

- **O(1)** extra space (if duplicates are handled manually and output list is returned).
- **O(k)** if using a `Set<List<Integer>>` to store unique triplets, where `k` is the number of valid triplets.

So, **Space Complexity = O(k)**

---




