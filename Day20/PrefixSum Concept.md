# Prefix Sum Algorithm

## What is a Prefix Sum?
A **prefix sum** is a technique where we precompute an array so that each position contains the **sum of all elements up to that position** in the original array.  

This allows us to **quickly answer range sum queries** in **O(1)** time after an **O(n)** preprocessing step.

---
## Example
Let’s say we have an array:

```
arr = [2, 4, 5, 7]
```
Prefix sum array:

    prefix[0] = arr[0] = 2

    prefix[1] = arr[0] + arr[1] = 2 + 4 = 6

    prefix[2] = arr[0] + arr[1] + arr[2] = 2 + 4 + 5 = 11

    prefix[3] = arr[0] + arr[1] + arr[2] + arr[3] = 2 + 4 + 5 + 7 = 18

Result:
    prefix = [2, 6, 11, 18]

## How to Use It

If you want to find the sum of elements between index `l` and `r`:

**Formula:**
sum(l, r) = prefix[r] - prefix[l-1] (if l > 0)
sum(l, r) = prefix[r] (if l == 0)


**Example:**  
Find the sum from index `1` to `3` (`4 + 5 + 7`):

sum(1, 3) = prefix[3] - prefix[0]= 18 - 2 = 16


## Algorithm Steps
1. Create a `prefix` array of the same size as `arr`.
2. Set `prefix[0] = arr[0]`.
3. Loop from `i = 1` to `n-1`:
    ```prefix[i] = prefix[i-1] + arr[i]
    ```
4. Use the formula to answer queries in **O(1)** time.

---

## Time Complexity
- **Building prefix array:** `O(n)`
- **Query sum in range:** `O(1)`
- **Space complexity:** `O(n)` (can be optimized to `O(1)` if computed in-place)


# Java Implementation
```
public class PrefixSumExample {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7};
        int n = arr.length;

        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Example: sum from index 1 to 3
        int l = 1, r = 3;
        int sum = (l == 0) ? prefix[r] : prefix[r] - prefix[l - 1];

        System.out.println("Sum from " + l + " to " + r + " = " + sum);
    }
}
```

## Real-World Use Cases
- **Fast range sum queries** (competitive programming, database analytics)
- **Calculating cumulative totals** in reports
- **Finding subarray sums** quickly
- Solving problems like:
  - **Maximum subarray sum with constraints**
  - **2D prefix sums** for image processing or game maps
