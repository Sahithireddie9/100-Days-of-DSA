# 141. Linked List Cycle — README

## 🧩 Problem Statement
Given the head of a singly linked list, determine if the list contains a **cycle**.  
A cycle exists if some node can be reached again by continuously following `next` pointers.

Return:
- `true` if a cycle exists
- `false` otherwise

> In LeetCode, `pos` is used only to **construct** the input (the tail connects to the node at index `pos`). It is **not** provided to your function.

---

## 📌 Examples
**Example 1**  
Input: `head = [3,2,0,-4], pos = 1`  
Output: `true`  
Explanation: The tail connects to index `1` (value `2`).

**Example 2**  
Input: `head = [1,2], pos = 0`  
Output: `true`  
Explanation: The tail connects to index `0` (value `1`).

**Example 3**  
Input: `head = [1], pos = -1`  
Output: `false`  
Explanation: Single node, no cycle.

---

## ✅ Constraints
- `0 ≤ n ≤ 10^4`
- `-10^5 ≤ Node.val ≤ 10^5`
- `pos ∈ {-1} ∪ [0, n-1]`

---

## Approach 1 — Brute Force (Hashing)

### Intuition
Track every node you visit in a **set**. If you encounter the same node again, a cycle exists.

### Pseudocode
```
function hasCycle(head):
    seen = empty set
    curr = head
    while curr != null:
        if curr in seen:
            return true
        add curr to seen
        curr = curr.next
    return false
```

### Time & Space Complexity
- **Time:** `O(n)` — each node processed at most once.  
- **Space:** `O(n)` — may store all nodes if no cycle.

### Java (Clean)
```java
import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SolutionHashing {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (seen.contains(curr)) return true;
            seen.add(curr);
            curr = curr.next;
        }
        return false;
    }
}
```

---

## Approach 2 — Optimal (Floyd’s Tortoise & Hare) — O(1) Space

### Intuition
Use two pointers:
- `slow` moves 1 step
- `fast` moves 2 steps  
If there’s a cycle, the fast pointer will eventually **meet** the slow pointer inside the cycle. If `fast` reaches `null`, no cycle.

### Pseudocode
```
function hasCycle(head):
    slow = head
    fast = head
    while fast != null and fast.next != null:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            return true
    return false
```

### Time & Space Complexity
- **Time:** `O(n)`  
- **Space:** `O(1)` — only pointers used

### Java (LeetCode-Ready)
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
```

---

## 🔬 Edge Cases to Verify
- `head = null` → `false`
- Single node, `head.next = null` → `false`
- Single node cycle, `head.next = head` → `true`
- Multiple nodes, no cycle → `false`
- Tail connects back to middle/head → `true`

---

## TL;DR
- **Hashing:** Simple to reason about, `O(n)` time, `O(n)` space.  
- **Floyd:** Same `O(n)` time with **`O(1)` space** → preferred for the follow-up.
