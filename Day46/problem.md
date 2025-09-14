# Binary Tree Level Order Traversal

## Problem Statement
Given the root of a binary tree, return the **level order traversal** of its nodes' values.  
(i.e., from left to right, level by level).

---

## Examples

### Example 1
**Input:**  
```
root = [3,9,20,null,null,15,7]
```
**Tree:**
```
        3
       / \
      9   20
         /  \
        15   7
```
**Output:**  
```
[[3],[9,20],[15,7]]
```

---

### Example 2
**Input:**  
```
root = [1]
```
**Output:**  
```
[[1]]
```

---

### Example 3
**Input:**  
```
root = []
```
**Output:**  
```
[]
```

---

## Intuition
- This is a **Breadth-First Search (BFS)** problem.  
- We process nodes **level by level** using a **queue (FIFO)**.  
- For each level:
  1. Count how many nodes are in the current level (`queue.size()`).  
  2. Process those nodes and add their children to the queue.  
  3. Store the values of the current level in the result.  

---

## Pseudocode
```
function levelOrder(root):
    if root is null:
        return []

    queue ← new Queue()
    queue.add(root)
    result ← []

    while queue is not empty:
        size ← queue.size()
        level ← []

        for i in range(0, size):
            node ← queue.poll()
            level.add(node.value)

            if node.left ≠ null:
                queue.add(node.left)
            if node.right ≠ null:
                queue.add(node.right)

        result.add(level)

    return result
```

---

## Time Complexity
- **O(n)** → Each node is processed once.  

## Space Complexity
- **O(n)** → In the worst case, the queue holds all nodes of the last level.  

---
