
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);          // empty prefix
        int presum = 0;
        int count = 0;

        for (int x : nums) {
            presum += x;

            // subarrays ending here with sum k
            count += freq.getOrDefault(presum - k, 0);

            // record current prefix sum
            freq.put(presum, freq.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
