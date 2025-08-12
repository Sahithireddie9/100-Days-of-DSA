package Day22;

public class BinarySearchRecursive {
    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target); // Search right half
        } else {
            return binarySearch(nums, left, mid - 1, target); // Search left half
        }
    }

    public static void main(String[] args) {
        int[] nums = {-5, -2, 0, 3, 8, 12, 20};
        int target = 8;
        System.out.println(binarySearch(nums, 0, nums.length - 1, target)); // Output: 4
    }
}

