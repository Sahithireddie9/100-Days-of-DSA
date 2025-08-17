package Day27;
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even so we can compare with mid + 1 safely
            if ((mid & 1) == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                // Pair is valid to the left of (and including) mid+1
                low = mid + 2;
            } else {
                // Pair breaks here, single is at mid or to its left
                high = mid;
            }
        }
        return nums[low];
    }

    // quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8})); // 2
        System.out.println(s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));   // 10
        System.out.println(s.singleNonDuplicate(new int[]{5}));                  // 5
    }
}


