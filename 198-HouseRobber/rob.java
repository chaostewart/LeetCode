class Solution {
    public int rob(int[] nums) {
        /*
        // space: O(n), time: O(n)
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) { 
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 1]), nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
        */
        
        // space: O(1), time: O(n)
        int robbedPrevYes = 0, robbedPrevNo = 0;
        for (int m : nums) {
            // if rob current house, must not rob previous house
            int robCurrYes = m + robbedPrevNo;
            // if not rob current house, update sum with max of two prev values
            int robCurrNo = Math.max(robbedPrevYes, robbedPrevNo);
            robbedPrevYes = robCurrYes;
            robbedPrevNo = robCurrNo;
        }
        return Math.max(robbedPrevYes, robbedPrevNo);

    }
}