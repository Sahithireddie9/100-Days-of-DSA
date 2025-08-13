# Lower Bound – Binary Search Variation

## **Definition**
In a **sorted array**, the **lower bound** of a target value is the **first index** where the element is **greater than or equal to** the target.

- If such an element exists → return its index.
- If all elements are smaller → return `arr.length` (position after the last element).

---

## **Example 1**
**Array:** `[1, 3, 3, 5, 7]`  
**Target:** `3`

- `arr[0] = 1` → less than 3 → skip  
- `arr[1] = 3` → **equal to 3** → stop here  
 **Lower Bound index = 1**

---

## **Example 2**
**Array:** `[1, 3, 3, 5, 7]`  
**Target:** `4`

- `arr[0] = 1` → less → skip  
- `arr[1] = 3` → less → skip  
- `arr[2] = 3` → less → skip  
- `arr[3] = 5` → **greater than 4** → stop  
**Lower Bound index = 3**

---

## **Key Points**
- Works **only on sorted arrays**.
- Uses **binary search** to achieve **O(log n)** time complexity.
- If the target is smaller than all elements → returns `0`.
- If the target is larger than all elements → returns `n` (past last index).

---

## **Algorithm / Intuition**
We use binary search but **don’t stop when we find the target** — instead, we move `high` down to `mid` when `arr[mid] >= target`, because there might be an earlier occurrence.

**Steps:**
1. Start with `low = 0`, `high = n` (not `n-1`, because we might insert after last).
2. While `low < high`:
   - Find `mid = low + (high - low) / 2`
   - If `arr[mid] >= target` → `high = mid`
   - Else → `low = mid + 1`
3. Return `low` (first index where element ≥ target).

---

## **Pseudocode**
```java
int lowerBound(int[] arr, int target) {
    int low = 0, high = arr.length;
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] >= target) {
            high = mid; // Look left for earlier occurrence
        } else {
            low = mid + 1; // Look right
        }
    }
    return low;
}
```

## **Time Complexity**
- **O(log n)** → halves the search space at each step  
- **O(1)** → constant extra space



# Upper Bound – Binary Search Variation

## **Definition**
In a **sorted array**, the **upper bound** of a target value is the **first index** where the element is **strictly greater than** the target.

- If such an element exists → return its index.
- If all elements are ≤ target → return `arr.length` (position after the last element).

> Think of it as: "Where can I insert this element so that it comes **after** all equal elements?"

---

## **Example 1**
**Array:** `[1, 3, 3, 5, 7]`  
**Target:** `3`

- `arr[0] = 1` → less → skip  
- `arr[1] = 3` → equal → keep searching right  
- `arr[2] = 3` → equal → keep searching right  
- `arr[3] = 5` → greater than 3 → stop  
✅ **Upper Bound index = 3**

---

## **Example 2**
**Array:** `[1, 3, 3, 5, 7]`  
**Target:** `6`

- `arr[0] = 1` → less → skip  
- `arr[1] = 3` → less → skip  
- `arr[2] = 3` → less → skip  
- `arr[3] = 5` → less → skip  
- `arr[4] = 7` → greater than 6 → stop  
✅ **Upper Bound index = 4**

---

## **Key Points**
- Works **only on sorted arrays**.
- Finds the **first element strictly greater** than the target.
- Useful for counting occurrences (`upper_bound - lower_bound`).
- If the target is larger than all elements → returns `n` (past last index).

---

## **Algorithm / Intuition**
We use binary search but move `high` down to `mid` when `arr[mid] > target`,  
because the first greater element might be on the left.

**Steps:**
1. Start with `low = 0`, `high = n`.
2. While `low < high`:
   - Find `mid = low + (high - low) / 2`
   - If `arr[mid] > target` → `high = mid`
   - Else → `low = mid + 1`
3. Return `low` (first index where element > target).

---

## **Pseudocode (Java)**
```java
int upperBound(int[] arr, int target) {
    int low = 0, high = arr.length;
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] > target) {
            high = mid; // Look left for first greater element
        } else {
            low = mid + 1; // Look right
        }
    }
    return low;
}
```

## **Time Complexity**
- **O(log n)** → halves the search space at each step  
- **O(1)** → constant extra space


---

# **Search Insert Position**
This problem is **nothing but finding the Lower Bound** in a sorted array.

- If the target exists, the lower bound returns its index.  
- If it doesn’t exist, it returns the index where the target should be inserted to keep the array sorted.  

**Example:**  
Array: `[1, 3, 5, 6]`, Target: `2` → Lower Bound = **1** → Insert at index 1.  

---

## **Floor and Ceil in a Sorted Array**

- **Ceil** → The smallest element **greater than or equal to** the target.  
  - In a sorted array, **Ceil is simply the Lower Bound** index.  
  - If the lower bound index is within array bounds → `arr[lb]` is the Ceil.  
  - If lower bound index equals `n` → Ceil does not exist.

- **Floor** → The largest element **less than or equal to** the target.  
  - Can be found using `upperBound(target) - 1`.  
  - If index ≥ 0 → `arr[index]` is the Floor.  
  - If index < 0 → Floor does not exist.

**Example:**  
Array: `[1, 3, 5, 7, 9]`, Target: `6`  
- Lower Bound index = 3 → Ceil = `7`  
- Upper Bound index = 3 → Floor index = 2 → Floor = `5`
