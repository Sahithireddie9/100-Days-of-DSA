package Day39;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class SolutionIterative {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextNode = current.next; // save next
            current.next = prev;              // reverse pointer
            prev = current;                   // move prev forward
            current = nextNode;               // move current forward
        }
        
        return prev; // new head
    }
}
