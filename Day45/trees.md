
#  Trees in Data Structures — Complete Guide 

## 1) What is a Tree? 

A **tree** is a hierarchical data structure made of **nodes** connected by **edges**.  
It has:
- a single **root** node at the top (no parent),
- **children** nodes below each node,
- and **edges** connecting parent → child.

Unlike arrays or linked lists (which are linear), trees naturally represent **hierarchies** like folders, organization charts, HTML DOM, etc.

```
            Root (A)
           /       \
        (B)         (C)
       /   \           \
     (D)   (E)         (F)
```

---

## 2) Why do we use Trees? 

- **Hierarchical modeling:** File systems, DOM, org charts, taxonomy trees.
- **Fast search & ordering:** BSTs can search/insert/delete in **O(log n)** (when balanced).
- **Prefix-based lookups:** Tries for auto-complete, spell-check, IP routing.
- **Priority scheduling:** Heaps for priority queues, Dijkstra’s algorithm.
- **Indexing large data:** B-Trees/B+Trees power **databases** and **filesystems**.
- **Divide-and-conquer:** Many algorithms are naturally recursive on subtrees.
- **Memory efficiency & flexibility:** No fixed size; grow/shrink dynamically.

---

## 3) Basic Terminology 

- **Node:** Single element (stores value + pointers to children).
- **Edge:** Connection between parent and child.
- **Root:** Topmost node (no parent).
- **Parent/Child/Sibling:** Relationships among nodes.
- **Leaf:** Node with **no children**.
- **Subtree:** Any node plus all nodes below it.
- **Height of node:** Longest downward path to a leaf.  
  **Height of tree:** Height of the root.
- **Depth of node:** Number of edges from root to that node.
- **Degree:** Number of children a node has.
- **Balanced tree:** Heights of left/right subtrees are close (roughly `O(log n)` height).
- **Complete Binary Tree:** All levels filled except possibly last; last level filled **left to right**.
- **Full (Proper) Binary Tree:** Each node has **0 or 2** children (no node with exactly 1 child).
- **Perfect Binary Tree:** All internal nodes have 2 children **and** all leaves are at the same level.

---

## 4) Types of Trees 

- **General Tree:** Any number of children.
- **Binary Tree:** Each node has **≤ 2 children** (left & right).
- **Binary Search Tree (BST):** Binary tree with ordering rule:  
  `left < root < right` (for all nodes). Enables fast search/insert/delete.
- **Balanced BSTs:** Keep height ~ `O(log n)` automatically:  
  **AVL**, **Red-Black Tree**, **Treap**, **Splay Tree** (different balancing strategies).
- **Heap (Binary Heap):** Complete binary tree maintaining **heap property**:  
  - **Max-heap:** parent ≥ children (top is maximum).  
  - **Min-heap:** parent ≤ children (top is minimum).  
  Backing structure for **priority queues**.
- **Trie (Prefix Tree):** Each edge represents a character; nodes represent prefixes. Great for **autocomplete** & **dictionary** operations.
- **Segment Tree / Fenwick (BIT):** Range queries and updates over arrays (sum/min/max, etc.).
- **B-Tree / B+Tree:** Multi-way search trees optimized for disk; used in **DB indexes**.

---

## 5) Binary Tree Traversals (Depth-First)

> **Goal:** Visit every node **exactly once** in a specific order.

### 5.1 Inorder (Left → Root → Right)
- **When to use:** In a **BST**, inorder yields **sorted order**.
- **Idea:** Recurse/iterate left, then process root, then right.

**Recursive Pseudocode**
```
INORDER(node):
  if node == NULL: return
  INORDER(node.left)
  visit(node)  // e.g., print or collect value
  INORDER(node.right)
```

**Iterative (using Stack)**
```
INORDER_ITERATIVE(root):
  stack = empty
  curr = root

  while curr != NULL or stack not empty:
    while curr != NULL:
      push(stack, curr)
      curr = curr.left

    curr = pop(stack)
    visit(curr)
    curr = curr.right
```

---

### 5.2 Preorder (Root → Left → Right)
- **When to use:** Copying a tree, building prefix expressions, serialization.
- **Idea:** Process root first, then left subtree, then right subtree.

**Recursive Pseudocode**
```
PREORDER(node):
  if node == NULL: return
  visit(node)
  PREORDER(node.left)
  PREORDER(node.right)
```

**Iterative (using Stack)**
```
PREORDER_ITERATIVE(root):
  if root == NULL: return
  stack = [root]

  while stack not empty:
    node = pop(stack)
    visit(node)
    if node.right != NULL: push(stack, node.right)
    if node.left  != NULL: push(stack, node.left)
  // push right first so left is processed first
```

---

### 5.3 Postorder (Left → Right → Root)
- **When to use:** Deleting/freeing a tree (process children before parent), postfix expressions.
- **Idea:** Process both subtrees, then the node.

**Recursive Pseudocode**
```
POSTORDER(node):
  if node == NULL: return
  POSTORDER(node.left)
  POSTORDER(node.right)
  visit(node)
```

**Iterative (Two-Stack)**
```
POSTORDER_ITERATIVE_TWO_STACKS(root):
  if root == NULL: return
  s1 = [root]
  s2 = []

  while s1 not empty:
    node = pop(s1)
    push(s2, node)
    if node.left  != NULL: push(s1, node.left)
    if node.right != NULL: push(s1, node.right)

  while s2 not empty:
    visit(pop(s2))
```

**Iterative (One-Stack) — trickier but space-efficient**
```
POSTORDER_ITERATIVE_ONE_STACK(root):
  stack = []
  lastVisited = NULL
  curr = root

  while curr != NULL or stack not empty:
    if curr != NULL:
      push(stack, curr)
      curr = curr.left
    else:
      peekNode = top(stack)
      // if right child exists and not yet visited, go right
      if peekNode.right != NULL and lastVisited != peekNode.right:
        curr = peekNode.right
      else:
        visit(peekNode)
        lastVisited = pop(stack)
```


