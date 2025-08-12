package Day22;
public class BinarySearchIterative {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; 

            if (nums[mid] == target) {
                return mid; // Found target
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {-5, -2, 0, 3, 8, 12, 20};
        int target = 8;
        System.out.println(binarySearch(nums, target)); // Output: 4
    }
}
