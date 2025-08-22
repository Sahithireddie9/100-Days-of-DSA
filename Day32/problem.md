# Capacity To Ship Packages Within D Days

A conveyor belt has packages with weights `weights[i]`. Each day, we load the ship with packages **in order** without exceeding the ship’s capacity. Given an integer `days`, return the **minimum ship capacity** so that all packages are shipped within `days` days.

---

## Examples

**Example 1**

```text
Input:  weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation:
Day 1: 1,2,3,4,5
Day 2: 6,7
Day 3: 8
Day 4: 9
Day 5: 10
```

**Example 2**

```text
Input:  weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation:
Day 1: 3,2
Day 2: 2,4
Day 3: 1,4
```

**Example 3**

```text
Input:  weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
Day 1: 1
Day 2: 2
Day 3: 3
Day 4: 1,1
```

> **Note:** Packages must be shipped **in the given order**. You cannot split or reorder packages.

---

## Brute Force

### Intuition
The capacity must be at least the heaviest package and at most the sum of all packages:
- **Lower bound** `L = max(weights)` (otherwise you can’t load that item).
- **Upper bound** `R = sum(weights)` (ship everything in one day).

A brute-force approach is to **try every capacity `cap` from `L` to `R`**, simulate loading day by day, and return the first `cap` that fits within `days`.

### Pseudocode (Brute)
```text
function daysNeeded(weights, cap):
    days = 1
    load = 0
    for w in weights:
        if load + w <= cap:
            load += w
        else:
            days += 1
            load = w
    return days

function shipWithinDays_bruteforce(weights, days):
    L = max(weights)
    R = sum(weights)

    for cap from L to R:
        if daysNeeded(weights, cap) <= days:
            return cap
```
### Time Complexity
- Let `n = len(weights)`, `S = sum(weights)`, `M = max(weights)`.
- **Time:** `O(n * (S - M + 1))` — potentially very slow for large sums.
### Space Complexity
- **Space:** `O(1)`

---

## Optimal Solution — Binary Search on Capacity

### Intuition
If a capacity `cap` is **enough** to ship within `days`, then **any larger capacity** will also be enough.  
This monotonic property lets us **binary search** the minimal feasible capacity between `L = max(weights)` and `R = sum(weights)`.

### Pseudocode (Optimal)
```text
function daysNeeded(weights, cap):
    days = 1
    load = 0
    for w in weights:
        if load + w <= cap:
            load += w
        else:
            days += 1
            load = w
    return days

function canShip(weights, days, cap):
    return daysNeeded(weights, cap) <= days

function shipWithinDays(weights, days):
    L = max(weights)
    R = sum(weights)

    while L < R:
        mid = (L + R) // 2
        if canShip(weights, days, mid):
            R = mid        // mid works; try smaller capacity
        else:
            L = mid + 1    // mid too small; increase capacity
    return L
```
### Time Complexity
- **Time:** `O(n * log(S - M + 1))` — simulate once per binary search step.
### Space Complexity
- **Space:** `O(1)`

---


