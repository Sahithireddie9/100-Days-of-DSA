package Day04;

import java.util.*;

public class FirstNegativeInWindow {

    public static List<Integer> firstNegativeOptimal(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            // Step 1: Add current index if it's negative
            if (arr[end] < 0) {
                dq.offerLast(end);
            }

            // Step 2: If we hit the window size
            if (end - start + 1 == k) {

                // Step 3: Check if deque has any negative index in this window
                if (!dq.isEmpty()) {
                    result.add(arr[dq.peekFirst()]);
                } else {
                    result.add(0);
                }

                // Step 4: Remove index that is out of the window
                if (!dq.isEmpty() && dq.peekFirst() == start) {
                    dq.pollFirst();
                }

                // Slide the window
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {-8, 2, 3, -6, 10};
        int[] arr2 = {12, -1, -7, 8, -15, 30, 16, 28};
        int[] arr3 = {12, 1, 3, 5};

        System.out.println(firstNegativeOptimal(arr1, 2)); // [-8, 0, -6, -6]
        System.out.println(firstNegativeOptimal(arr2, 3)); // [-1, -1, -7, -15, -15, 0]
        System.out.println(firstNegativeOptimal(arr3, 3)); // [0, 0]
    }
}

