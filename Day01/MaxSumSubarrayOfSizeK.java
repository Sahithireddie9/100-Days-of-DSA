package Day01;

public class MaxSumSubarrayOfSizeK {

    public static int maxSum(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        int windowSum = 0;
        int maxSum;

        // Compute the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Slide the window: remove element going out, add element coming in
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSum(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
    
}
