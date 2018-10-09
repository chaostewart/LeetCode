class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];     //dp[i] means the maximum subarray ending with nums[i];
        dp[0] = nums[0];
        int res= dp[0];
        
        for(int i = 1; i < nums.length; i++){
            // if previous subarray has sum larger than 0, then attach the current to previous
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}
