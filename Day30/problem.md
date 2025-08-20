# 📝 Problem Statement
Given a positive integer `n`, find the **square root** of `n`.  
- If `n` is a **perfect square**, return its exact square root.  
- Otherwise, return the **floor value** of the square root (the greatest integer ≤ √n).  

---

## 🔹 Examples
**Input:** `n = 4`  
**Output:** `2`  
**Explanation:** Since `4` is a perfect square, √4 = 2.  

**Input:** `n = 11`  
**Output:** `3`  
**Explanation:** Since `11` is not a perfect square, √11 ≈ 3.316. Floor value = 3.  

**Input:** `n = 1`  
**Output:** `1`  
**Explanation:** Since `1` is a perfect square, √1 = 1.  

---

## 🔹 Constraints
```
1 ≤ n ≤ 3 * 10^4
```

---

# 🚀 Solutions

---

## 1️⃣ Brute Force Approach

### 🔹 Intuition
- Start from `1` and keep squaring numbers until the square exceeds `n`.  
- The last number whose square ≤ `n` is the answer.  

### 🔹 Pseudocode
```
function floorSqrt(n):
    ans = 1
    for i from 1 to n:
        if i * i <= n:
            ans = i
        else:
            break
    return ans
```

### 🔹 Time Complexity
```
O(n)
```

---

## 2️⃣ Optimal Approach (Binary Search)

### 🔹 Intuition
- The square root of `n` always lies between `1` and `n`.  
- Use **binary search** to find the largest integer `x` such that `x*x ≤ n`.  

### 🔹 Pseudocode
```
function floorSqrt(n):
    low = 1, high = n, ans = 0
    while low <= high:
        mid = (low + high) / 2
        if mid * mid == n:
            return mid
        else if mid * mid < n:
            ans = mid
            low = mid + 1
        else:
            high = mid - 1
    return ans
```

### 🔹 Time Complexity
```
O(log n)


