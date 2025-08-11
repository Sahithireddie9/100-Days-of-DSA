package Day21;
class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum=Integer.MIN_VALUE;
        int currentSum=0;
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            bestSum=Math.max(currentSum,bestSum);
            if(currentSum<0){
                currentSum=0;
            }
        }
        return bestSum;
        
    }
}