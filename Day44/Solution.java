package Day44;

class ListNode {
         int val;
       ListNode next;
        ListNode() {}
      ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify list building
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        // Continue while either list has nodes or a carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            // Create new node with the current digit
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            // Move forward in lists if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}