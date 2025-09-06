# LeetCode 876 — Middle of the Linked List

---

## 📌 Problem Statement

Given the head of a singly linked list, return the **middle node** of the linked list.  
If there are two middle nodes, return the **second** middle node.

### Constraints
- The number of nodes in the list is in the range `[1, 100]`.
- `1 <= Node.val <= 100`

---

## 📘 Examples

**Example 1:**  
Input: `head = [1,2,3,4,5]`  
Output: `[3,4,5]`  
Explanation: The middle node is `3`.

**Example 2:**  
Input: `head = [1,2,3,4,5,6]`  
Output: `[4,5,6]`  
Explanation: Two middle nodes `3` and `4`, return the **second** one.

---

## 🧠 Brute Force Approach

### Intuition
1. Traverse the list to **count** the total number of nodes.  
2. Compute the middle index as `count / 2 + 1` (1-indexed to ensure the **second middle** is chosen for even length).  
3. Traverse again until the middle index is reached and return that node.

### Pseudocode
```
function middleNode(head):
    if head == null or head.next == null:
        return head

    count = 0
    temp = head

    # First pass: count nodes
    while temp != null:
        count += 1
        temp = temp.next

    mid = count // 2 + 1

    # Second pass: reach mid node
    temp = head
    while mid > 1:
        temp = temp.next
        mid -= 1

    return temp
```

### Complexity
- **Time Complexity:** `O(n)` (two passes through list)
- **Space Complexity:** `O(1)`

---

## ⚡ Optimal Approach (Tortoise–Hare, Two Pointers)

### Intuition
- Use **two pointers**:
  - `slow` moves **1 step** at a time.
  - `fast` moves **2 steps** at a time.  
- When `fast` reaches the end, `slow` is at the **middle**.  
- In an even-length list, this naturally lands `slow` on the **second middle**.

### Pseudocode
```
function middleNode(head):
    slow = head
    fast = head

    while fast != null and fast.next != null:
        slow = slow.next
        fast = fast.next.next

    return slow
```

### Complexity
- **Time Complexity:** `O(n)` (single pass)
- **Space Complexity:** `O(1)`

---

## ✅ Key Takeaways
- Brute force uses **two passes**: count then locate.  
- Optimal approach uses **one pass** with two pointers.  
- Both are `O(n)` time and `O(1)` space, but the two-pointer method is more elegant.

