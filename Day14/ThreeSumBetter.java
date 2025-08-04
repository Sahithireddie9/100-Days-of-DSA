package Day14;
import java.util.*;
public class ThreeSumBetter {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int k = -(nums[i] + nums[j]);

                if (seen.contains(k)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(triplet); // to avoid duplicate sets like [1, -1, 0] and [-1, 0, 1]
                    result.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }

    // Test the solution
    public static void main(String[] args) {
        ThreeSumBetter solution = new ThreeSumBetter();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};

        System.out.println("Test Case 1: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.threeSum(nums1));

        System.out.println("\nTest Case 2: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.threeSum(nums2));

        System.out.println("\nTest Case 3: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.threeSum(nums3));
    }

    
}
