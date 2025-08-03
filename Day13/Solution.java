package Day13;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int k = sol.removeElement(nums, val);
        System.out.println("Number of elements after removal: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
