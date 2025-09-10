
# Add Two Numbers (Linked Lists) — README

**Difficulty:** Medium  
**Pattern:** Linked List, Simulation / Elementary Math

---

## Problem Statement

You are given two **non-empty** singly linked lists `l1` and `l2` representing two non-negative integers.  
The digits are stored in **reverse order**, and **each node contains a single digit**.  
Add the two numbers and return the **sum as a linked list** (also in reverse order).

You may assume the two numbers do **not contain any leading zeros**, except the number `0` itself.

---

## 🔢 Examples

**Example 1**  
Input: `l1 = [2,4,3]`, `l2 = [5,6,4]`  
Output: `[7,0,8]`  
Explanation: `342 + 465 = 807` → reversed as `[7,0,8]`

**Example 2**  
Input: `l1 = [0]`, `l2 = [0]`  
Output: `[0]`

**Example 3**  
Input: `l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]`  
Output: `[8,9,9,9,0,0,0,1]`  
Explanation: `9,999,999 + 9,999 = 10,009,998` → reversed

---

## Constraints
- `1 <= length(l1), length(l2) <= 100`
- `0 <= Node.val <= 9`
- Numbers have **no leading zeros** (except `0`)

---


## Optimal Approach (Digit-by-Digit with Carry)

### Intuition
Simulate column-wise addition like on paper:
- Walk both lists **simultaneously**.
- At each step, add `x = val(l1) + val(l2) + carry`.
- Create a new node with `x % 10`, update `carry = x // 10`.
- Continue until both lists are exhausted and `carry == 0`.

This avoids converting to full integers, **eliminates overflow risk**, and only uses constant extra space (besides the result list).

### Pseudocode
```text
function addTwoNumbers(l1, l2):
    dummy = new ListNode(0)
    tail = dummy
    carry = 0

    while l1 != null or l2 != null or carry != 0:
        v1 = l1.val if l1 != null else 0
        v2 = l2.val if l2 != null else 0
        s = v1 + v2 + carry
        carry = s // 10
        tail.next = new ListNode(s % 10)
        tail = tail.next

        if l1 != null: l1 = l1.next
        if l2 != null: l2 = l2.next

    return dummy.next
```

### Complexity
- **Time:** `O(max(n, m))`
- **Auxiliary Space:** `O(1)` (excluding the output list)
- **Output Size:** Up to `max(n, m) + 1` nodes (if final carry exists)

---

## Edge Cases To Verify
- Different lengths: `l1 = [9,9]`, `l2 = [1]` → `[0,0,1]`
- Final carry: `l1 = [5]`, `l2 = [5]` → `[0,1]`
- Single zero lists: `l1 = [0]`, `l2 = [0]` → `[0]`
- One list much longer than the other
- All 9’s + small number

---

## Takeaways
- Use the **digit-by-digit carry method** for correctness and scalability.
- Dummy head simplifies list building.
- Handle the **final carry** explicitly.

---

