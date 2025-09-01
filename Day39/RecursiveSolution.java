package Day39;
class SolutionRecursive {
    public ListNode reverseList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Adjust pointers
        head.next.next = head;
        head.next = null;

        return newHead; // new head of reversed list
    }
}
