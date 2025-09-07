
# Find Length of Loop in a Linked List

**Difficulty:** Medium  
**Goal:** Given the head of a singly linked list, determine whether the list contains a loop.  
If a loop exists, return the **number of nodes in the loop**; otherwise, return **0**.

> Internally, `pos` (1‑based) denotes the node position where the tail connects.  
> If `pos = 0`, the last node points to `null` ⇒ **no loop**. `pos` is *not* an input to your function—it’s only for constructing test cases.

---

## Examples

### Example 1
**Input:** `pos = 2` (tail connects to the 2nd node)  
**Output:** `4`  
**Explanation:** The cycle covers 4 nodes.

### Example 2
**Input:** `pos = 3`  
**Output:** `3`  
**Explanation:** The loop goes `19 → 33 → 10 → (back to 19)`; **length = 3**.

### Example 3
**Input:** `pos = 0`  
**Output:** `0`  
**Explanation:** No cycle.

---

## Intuition: What does “length of loop” mean?
If a linked list’s tail points back to some earlier node, we get a **cycle**. Starting from any node inside the cycle and moving `next` repeatedly, you’ll come back to the same node after visiting **L** nodes—`L` is exactly the **loop length**.

---

## Brute-Force Approach (Hashing)

### Idea
Walk through the list while keeping a **HashMap** of visited nodes and the **step index** (or “time”) when we first saw them.  
- If we see a node **again**, the difference between the current time and the time we first saw that node equals the **loop length**.  
- If we hit `null`, no loop exists.

### Pseudocode
```text
lengthOfLoop(head):
    visited = empty hash map from Node → index
    i = 0
    node = head
    while node != null:
        if node in visited:
            return i - visited[node]   // loop length
        visited[node] = i
        node = node.next
        i += 1
    return 0
```

### Correctness
- On first entry into a cycle, nodes keep repeating in a fixed order. The first repeated node’s index difference is exactly one full cycle.

### Complexity
- **Time:** `O(N)` — each node processed at most twice (insert + repeat check).  
- **Space:** `O(N)` — we store up to all nodes before the repeat.



---

## Optimal Approach (Floyd’s Cycle + Single Lap Count)

### Key Insight
Use **Floyd’s Tortoise and Hare** to detect a loop in `O(1)` space:
- Move `slow` by 1 step, `fast` by 2 steps.
- If they ever meet, a loop exists.
- To get the **length**: starting at the meeting point, move one pointer around the cycle counting steps until it returns to the same node.

### Why it works
Inside a cycle, relative speeds guarantee a meeting. From that meeting node, a full traversal along `next` returns to it after exactly **L** steps—**the loop length**.

### Pseudocode
```text
findLoopLengthFrom(meet):
    count = 1
    cur = meet.next
    while cur != meet:
        count += 1
        cur = cur.next
    return count

lengthOfLoop(head):
    slow = head
    fast = head
    while fast != null and fast.next != null:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            return findLoopLengthFrom(slow)
    return 0
```

### Complexity
- **Time:** `O(N)` — linear in number of nodes; detection + one lap around the cycle.  
- **Space:** `O(1)` — only pointers and counters.


## Edge Cases & Pitfalls
- Single node with `next` pointing to itself ⇒ **length = 1**.  
- Two nodes pointing to each other ⇒ **length = 2**.  
- Ensure `fast != null && fast.next != null` before doing `fast = fast.next.next`.  
- Don’t confuse “distance from head to loop” with “length of loop”—we only need the loop size.

---

## When to Use Which Approach?
- **Brute-force (Hashing):** Simple to reason about; useful for debugging or teaching.  
- **Optimal (Floyd):** Preferred in interviews and production—**`O(1)` space** and clean.

---

## 📘 Quick Comparison

| Aspect        | Brute Force (Hash) | Optimal (Floyd) |
|---------------|---------------------|------------------|
| Time          | O(N)                | O(N)             |
| Space         | O(N)                | O(1)             |
| Implementation| Easy                | Moderate         |
| Interview Fit | OK                  | Best             |

---

## Minimal Test Ideas
- No loop (`pos = 0`) → `0`  
- Self loop (1 node) → `1`  
- Small loop (2–3 nodes) → correct length  
- Long prefix then cycle → correct length  
- Large list to ensure `O(1)` extra space holds

---

## Final Notes
Both methods are correct; the **Floyd approach** is optimal on space and commonly expected in interviews. Always guard null checks carefully and count **exactly one full lap** after the pointers meet.
