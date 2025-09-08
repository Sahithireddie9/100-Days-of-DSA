# Find Pairs With Given Sum in a Doubly Linked List

## 📘 Problem Statement
Given a **sorted doubly linked list** and an integer `target`, return **all pairs of node values** `(x, y)` such that `x + y == target` and the node containing `x` appears **before** the node containing `y` in the list.

Return the pairs in **value order** as they are discovered by your approach (you may sort output if required by the platform). If the list has **no such pairs**, return an empty list.

> **Assumptions**
> - The list is **sorted in non-decreasing order**.
> - Each node has: `data`, `next`, and `prev` pointers.



---

## ✅ Examples

### Example 1
**Input**: `head = 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 9`, `target = 5`  
**Output**: `[[1, 4], [2, 3]]`  
**Explanation**: Pairs `1+4` and `2+3` sum to 5.

### Example 2
**Input**: `head = 1 ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 3 ⇄ 4`, `target = 4`  
**Output**: `[[1, 3], [1, 3], [2, 2]]`  
**Explanation**: Duplicates are treated as distinct nodes by position.

### Example 3
**Input**: `head = 2 ⇄ 4 ⇄ 6`, `target = 3`  
**Output**: `[]`  
**Explanation**: No valid pair exists.

---

## 🟠 Brute Force Approach

### Intuition
Compare **every pair** of nodes `(i, j)` where `i` comes before `j`. When `i.data + j.data == target`, record the pair. This is straightforward and works **regardless of sorting**, but it’s **O(n²)**.

### Pseudocode
```
function findPairsBruteForce(head, target):
    result = empty list
    i = head
    while i != null and i.next != null:
        j = i.next
        while j != null:
            if i.data + j.data == target:
                append [i.data, j.data] to result
            j = j.next
        i = i.next
    return result
```

### Complexity
- **Time**: `O(n²)` — nested loops over node pairs  
- **Space**: `O(1)` — ignoring the output list


---

## 🟢 Optimal Approach (Two Pointers on Sorted DLL)

### Intuition
Use the sorted property. Place one pointer `i` at the **head** and another `j` at the **tail**.  
- If `i.data + j.data == target`: record the pair and move both pointers inward.  
- If the sum is **less than** target: move `i` forward to increase the sum.  
- If the sum is **greater than** target: move `j` backward to decrease the sum.  
This visits each node at most once from each side.

### Pseudocode
```
function findPairsTwoPointers(head, target):
    result = empty list
    if head is null or head.next is null: 
        return result

    # get tail
    tail = head
    while tail.next != null:
        tail = tail.next

    i = head
    j = tail
    while i != null and j != null and i != j and j.next != i:
        sum = i.data + j.data
        if sum == target:
            append [i.data, j.data] to result
            i = i.next
            j = j.prev
        else if sum < target:
            i = i.next
        else:
            j = j.prev

    return result
```

### Complexity
- **Time**: `O(n)` — each pointer moves at most `n` steps total  
- **Space**: `O(1)` — aside from output

