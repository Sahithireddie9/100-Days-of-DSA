# Koko Eating Bananas

Koko loves to eat bananas. There are `n` piles of bananas, and the `i-th` pile has `piles[i]` bananas.  
The guards have gone and will come back in `h` hours.

Koko can decide her bananas-per-hour eating speed `k`.  
- Each hour, she chooses some pile of bananas and eats `k` bananas from that pile.  
- If the pile has fewer than `k` bananas, she eats all of them instead and will not eat more bananas during that hour.  

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

**Task:**  
Return the minimum integer `k` such that she can eat all the bananas within `h` hours.

---

## Examples

**Example 1:** Input: piles = [3,6,7,11], h = 8 , Output: 4

**Example 2:** I
nput: piles = [30,11,23,4,20], h = 5  
Output: 30


**Example 3:** 
Input: piles = [30,11,23,4,20], h = 6  
Output: 23


---

## Constraints
- `1 <= piles.length <= 10^4`
- `piles.length <= h <= 10^9`
- `1 <= piles[i] <= 10^9`

## 🧠 Intuition  
Koko wants to eat all the bananas within `h` hours. Her eating speed `k` (bananas per hour) determines how long it will take.  

- If she eats **too slowly** (small `k`), she won’t finish in time.  
- If she eats **very fast** (large `k`), she will definitely finish, but that may not be the *minimum* speed.  

So the problem reduces to finding the **smallest `k`** such that:  
A simple brute force way is to **try every possible speed** from `1` up to the largest pile.  
The first `k` that allows her to finish within `h` hours is the answer.  

---
### Pseudocode
```function minEatingSpeed(piles, h):
    maxPile = maximum value in piles
    for k from 1 to maxPile:
        hours = 0
        for pile in piles:
            hours += ceil(pile / k)
        if hours <= h:
            return k
    return maxPile   
```

## 🧠 Intuition

- Let `k` be Koko’s eating speed (bananas/hour).
- For a fixed `k`, the hours needed to finish all piles is:
  \[
  \text{hours}(k) = \sum_{p \in \text{piles}} \left\lceil \frac{p}{k} \right\rceil
  \]
- **Monotonicity:** If a speed `k` is sufficient (i.e., `hours(k) ≤ h`), then any larger speed `k' > k` is also sufficient.  
  This monotone property lets us **binary search** the minimum feasible `k`.

- **Search range:**  
  - **low = 1** (slowest possible nonzero speed)  
  - **high = max(piles)** (fast enough to finish the largest pile in ≤ 1 hour)

We binary search on `k` and use a helper `canFinish(k)` to check feasibility.

---

## ✅ Key Idea

- Maintain the invariant: the answer lies in `[low, high]`.
- Midpoint `mid = (low + high) // 2`.
  - If `canFinish(mid)` is **true** (needs ≤ `h` hours), move left: `high = mid`.
  - Else move right: `low = mid + 1`.
- When `low == high`, that index is the minimal feasible `k`.

---

## 🧩 Pseudocode
```
function minEatingSpeed(piles, h):
    low  = 1
    high = maximum value in piles

    function canFinish(k):
        hours = 0
        for pile in piles:
            hours += (pile + k - 1) // k   // ceil division
            if hours > h:
                return false
        return hours <= h

    while low < high:
        mid = (low + high) // 2
        if canFinish(mid):
            high = mid        // mid works, try smaller k
        else:
            low = mid + 1     // mid too slow, try larger k

    return low
```

