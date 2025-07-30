# ✅ Day 09: 283. Move Zeroes

## Problem Statement
Given an integer array `nums`, move **all `0`s** to the **end** of the array **in-place**, while **maintaining the relative order** of the non-zero elements.

You must do this **in-place** (no extra copy of the array).

---

## Examples
**Example 1**
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

**Example 2**
Input: nums = [0]
Output: [0]


## 📏 Constraints
- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
---

## ⚡ Optimal Solution (Two Pointers, O(n), O(1))

You can do this in **linear time** and **constant space**. Two neat, stable variants:

### ✅ Option A — Compact Non‑Zeros, Then Fill Zeros (fewer writes)
**Idea:** First pass writes all non‑zeros to the front in order.  
Second pass fills the remaining positions with zeros.

#### Pseudocode
write = 0
for read from 0 to n-1:
if nums[read] != 0:
nums[write] = nums[read]
write += 1

while write < n:
nums[write] = 0
write += 1


- **Time:** O(n)
- **Space:** O(1)
- **Use when:** Many zeros → minimizes swaps/writes.

---

### ✅ Option B — Single Pass with Swaps (lastNonZeroIndex)
**Idea:** Track `last` = where the next non‑zero belongs.  
When you see a non‑zero at `read`, swap `nums[last]` and `nums[read]`, then `last++`.

## Pseudocode
```last = 0
for read from 0 to n-1:
if nums[read] != 0:
swap(nums[last], nums[read])
last += 1
```


- **Time:** O(n)
- **Space:** O(1)
- **Notes:** Also stable for non‑zero order; very concise.

---

## Extra Test Cases
- `[0,0,0]        → [0,0,0]`
- `[1,2,3]        → [1,2,3]`
- `[4,0,5,0,6]    → [4,5,6,0,0]`
- `[-1,0,-2,3,0]  → [-1,-2,3,0,0]`
- `[0,1]          → [1,0]`

---

## Takeaway
Both optimal variants are **O(n) time / O(1) space** and keep the **relative order** of non‑zeros:
- **Option A**: fewer total writes (great with many zeros).
- **Option B**: clean single pass with intuitive swaps.

```