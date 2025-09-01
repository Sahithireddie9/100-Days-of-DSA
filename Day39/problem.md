

## Problem Statement

Given the beginning of a singly linked list `head`, reverse the list and
return the new beginning of the list.

### Example 1

**Input:**\
head = \[0,1,2,3\]

**Output:**\
\[3,2,1,0\]

---
### Example 2

**Input:**\
head = \[\]

**Output:**\
\[\]

---

## Constraints

-   0 \<= length of the list \<= 1000\
-   -1000 \<= Node.val \<= 1000

---

## Optimal Intuition

Instead of using extra space, we can **reverse pointers in place**.\
We iterate through the list, and for each node: 1. Keep track of the
next node.\
2. Point current node's `next` to previous node.\
3. Move `prev` and `current` one step forward.

At the end, `prev` will point to the new head of the reversed list.

---

## Optimal Pseudocode

    function reverseList(head):
        prev = null
        current = head
        
        while current is not null:
            nextNode = current.next   # store next
            current.next = prev       # reverse pointer
            prev = current            # move prev forward
            current = nextNode        # move current forward
        
        return prev

### Time Complexity

-   We only traverse the list once → **O(n)**

### Space Complexity

-   In-place reversal → **O(1)**
