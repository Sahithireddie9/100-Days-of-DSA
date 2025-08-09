# Day 19 — Maximum Non-Overlapping Meetings (Activity Selection)

## Problem Statement
You are given timings of **n** meetings in the form of two arrays:

- `start[i]` — start time of meeting **i**
- `end[i]` — end time of meeting **i**

Only **one** meeting can be held in the meeting room at a particular time.  
Return the **maximum number of meetings** that can be accommodated in a single meeting room.

**Important:** The start time of one chosen meeting **cannot** be equal to the end time of another chosen meeting (strictly greater).

---

## Examples

### Example 1
**Input**  start = [1, 3, 0, 5, 8, 5] end = [2, 4, 6, 7, 9, 9]
**Output**  4
**Explanation**  
Maximum four meetings can be held:  
(1, 2), (3, 4), (5, 7), (8, 9)

---

### Example 2
**Input**  start = [10, 12, 20]  end = [20, 25, 30]
**Output** 1
**Explanation**  
Only one meeting can be held.

---

### Example 3
**Input**   start = [1, 2] end = [100, 99]
**Output**  1


---

## Constraints
- `1 ≤ n ≤ 10^5`
- `0 ≤ start[i] < end[i] ≤ 10^6`

---

## Approach

### Intuition
To fit the **maximum number of meetings** in a single room, you should always free the room as early as possible so that more meetings can follow.  
This naturally suggests a **greedy** rule: **always pick the meeting that ends earliest among the remaining feasible ones**.

Why does this work?  
- Picking an earlier finishing meeting **never reduces** the number of future meetings you might take (it leaves the room available sooner).  
- Picking a later finishing meeting can **block** shorter meetings that would have allowed more total meetings.

---

### Greedy Strategy (Activity Selection)
1. **Pair and sort**
   - Build a list of pairs `meetings = [(start[i], end[i])]`.
   - Sort by **end time ascending**, and if end times tie, by **start time ascending**:  
     `meetings.sort(key=lambda (s, e): (e, s))`
2. **Select greedily with strict inequality**
   - Maintain `lastEnd = -∞` and `count = 0`.
   - Scan the sorted list:
     - If `current.start > lastEnd`, **select** it: `count += 1`, `lastEnd = current.end`.
   - The strict `>` is important because the problem states:  
     **“The start time of one chosen meeting cannot be equal to the end time of another chosen meeting.”**

---

### Correctness Sketch
- **Greedy-choice property:**  
  Suppose an optimal solution does not start with the earliest-ending feasible meeting `m`. Replace its first meeting with `m`:  
  - `m` ends no later than the first meeting in the optimal solution, so all remaining choices are still feasible.  
  - The total number of meetings is unchanged or improved.  
  Repeating this argument shows a schedule starting with earliest-ending choices is optimal.
- **Optimal substructure:**  
  After taking the earliest-ending meeting, the subproblem (“what to do after `lastEnd`”) is identical in form and independent of earlier choices.

---

### Algorithm (Step-by-step)
1. Create `meetings = [(start[i], end[i])]` for all `i`.
2. Sort `meetings` by `(end asc, start asc)`.
3. Initialize `count = 0`, `lastEnd = -∞`.
4. For each `(s, e)` in `meetings`:
   - If `s > lastEnd`:  
     - `count += 1`  
     - `lastEnd = e`
5. Return `count`.

**Time Complexity:** `O(n log n)` (sorting dominates)  
**Space Complexity:** `O(n)` for the pair list (or `O(1)` extra if sorting indices in place)

---

