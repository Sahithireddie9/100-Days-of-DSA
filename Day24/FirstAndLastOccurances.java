package Day24;

class Solution {
    public int[] searchRange(int[] arr, int target) {
        // Handle edge case: empty array
        if (arr.length == 0) {
            return new int[]{-1, -1};
        }

        int n = arr.length;
        int lower = n, upper = n;
        int low = 0, high = n - 1;

        // Binary search to find the first occurrence (lower bound)
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                lower = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // If target doesn't exist in the array
        if (lower == n || arr[lower] != target) {
            return new int[]{-1, -1};
        }

        // Binary search to find the index just after the last occurrence (upper bound)
        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                upper = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Return the first and last position of the target
        return new int[]{lower, upper - 1};
    }
}
