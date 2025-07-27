public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            currentSum += nums[right];
            right++;

            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left);
                currentSum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum length subarray with sum ≥ " + target + " is: " + result);
    }
}
