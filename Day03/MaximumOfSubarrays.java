package Day03;
import java.util.*;

public class MaximumOfSubarrays {

    public static List<Integer> maxOfSubarrays(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>(); // stores indexes

        for (int i = 0; i < arr.length; i++) {
            // Remove elements out of current window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Remove all elements smaller than the current element
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;

        int[] arr2 = {4, 2, 12, 3, -1, 0, 5};
        int k2 = 2;

        System.out.println("Output 1: " + maxOfSubarrays(arr1, k1)); // [3, 3, 5, 5, 6, 7]
        System.out.println("Output 2: " + maxOfSubarrays(arr2, k2)); // [4, 12, 12, 3, 0, 5]
    }
}

