package Day43;


class Node {
    int data;
    Node next, prev;
}

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
