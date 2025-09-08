package Day42;

import java.util.ArrayList;
import java.util.Arrays;



class Node {
    int data;
    Node next, prev;
    Node(int x) { data = x; }
}

class Solution {
    

    // Time: O(n), Space: O(1) besides output
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null || head.next == null) return res;

        // Move to tail
        Node tail = head;
        while (tail.next != null) tail = tail.next;

        Node i = head;
        Node j = tail;

        // Two-pointer sweep
        while (i != null && j != null && i != j && j.next != i) {
            int sum = i.data + j.data;

            if (sum == target) {
                // Record pair (smaller from left, larger from right)
                res.add(new ArrayList<>(Arrays.asList(i.data, j.data)));
                i = i.next;
                j = j.prev;
            } else if (sum < target) {
                i = i.next;      // need a larger sum
            } else {
                j = j.prev;      // need a smaller sum
            }
        }

        return res;
    }
}
