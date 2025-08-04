package Day14;
import java.util.*;
public class ThreeSumBrute {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        int n = nums.length;

        // Check all combinations of three different indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // Sorting ensures uniqueness in the Set
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    public static void main(String[] args) {
        
        ThreeSumBrute threeSumBrute=new ThreeSumBrute();
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};

        System.out.println("Test Case 1: " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSumBrute.threeSum(nums1));

        System.out.println("\nTest Case 2: " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSumBrute.threeSum(nums2));

        System.out.println("\nTest Case 3: " + Arrays.toString(nums3));
        System.out.println("Output: " + threeSumBrute.threeSum(nums3));
    }

    
}
