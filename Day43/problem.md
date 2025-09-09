# Remove Duplicates from a **Sorted** Doubly Linked List (README)

## 🚩 Problem Statement
Given the head of a **sorted** doubly linked list with `n` nodes, delete all duplicate nodes so that each distinct value appears exactly once. Return the head of the modified list.

- **Constraints:** `1 ≤ n ≤ 1e5`
- **Expected Time Complexity:** `O(n)`
- **Expected Space Complexity:** `O(1)`

The list is **sorted in non-decreasing order**, which guarantees that all duplicates of a value are **contiguous**.

---

## 📘 Examples

### Example 1
**Input:**  
`n = 6`  
`1 <-> 1 <-> 1 <-> 2 <-> 3 <-> 4`  

**Output:**  
`1 <-> 2 <-> 3 <-> 4`  

**Explanation:**  
Only the first occurrence of `1` is kept.

---

### Example 2
**Input:**  
`n = 7`  
`1 <-> 2 <-> 2 <-> 3 <-> 3 <-> 4 <-> 4`  

**Output:**  
`1 <-> 2 <-> 3 <-> 4`  

**Explanation:**  
For each of `2, 3, 4`, only the first occurrence remains.

---

## 💡 Optimal Intuition (One Pass, In-Place)

Because the list is **sorted**, any duplicates for a value `x` appear **right next to each other**.  
We can walk the list with a pointer `curr`:

- If `curr.data == curr.next.data`, then `curr.next` is a **duplicate** and should be **skipped**:
  - Set `curr.next = curr.next.next`
  - Also fix the backward link: if `curr.next != null`, set `curr.next.prev = curr`
- If values differ, simply move `curr` forward.

This removes duplicates **as we traverse**, using **O(1)** extra space and **O(n)** time.

---

## 🧪 Edge Cases to Consider
- All nodes have the same value → result should be a single node.
- No duplicates → list remains unchanged.
- Duplicates at the **head**, **middle**, or **tail**.
- Single-node list (`n = 1`).

---

## 🧯 Pseudocode

```text
function removeDuplicates(head):
    if head is null:
        return null

    curr = head
    while curr != null and curr.next != null:
        if curr.data == curr.next.data:
            # skip duplicate node
            duplicate = curr.next
            curr.next = duplicate.next
            if curr.next != null:
                curr.next.prev = curr
        else:
            curr = curr.next
    return head
```

---

## ⏱️ Complexity

- **Time:** `O(n)` — each node is visited at most once (duplicates are skipped in constant time).
- **Space:** `O(1)` — in-place relinking, no extra data structures.

---

## ✅ Reference Java Implementation

```java
// Definition for a doubly linked list node:
// class Node {
//     int data;
//     Node next, prev;
// }

class Solution {
    Node removeDuplicates(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                // Skip the duplicate node
                Node dup = curr.next;
                curr.next = dup.next;
                if (curr.next != null) {
                    curr.next.prev = curr;
                }
            } else {
                // Move to next distinct value
                curr = curr.next;
            }
        }
        return head;
    }
}
```

---

## 🧭 Testing Tips (Optional)
Build small helpers to create & print a DLL, then try:

- `[1,1,1,2,3,4] → [1,2,3,4]`
- `[1,2,2,3,3,4,4] → [1,2,3,4]`
- `[5,5,5,5] → [5]`
- `[1,2,3] → [1,2,3]`
```

