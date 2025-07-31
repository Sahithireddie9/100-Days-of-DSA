package Day10;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;                  // write pointer for last unique
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}