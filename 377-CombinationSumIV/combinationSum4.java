class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // fill the array with -1 to indicate that the result hasn't been calculated yet
        // 0 is not a good choice because it means there is no combination sum for the target.
        Arrays.fill(dp, -1);
        // when target is decreased to 0, one combination is found
        dp[0] = 1;
        helper(dp, nums, target);
        return dp[target];
    }
    
    private int helper(int[] dp, int[] nums, int target) {
        // if this target has been calculated before, return that result
        if (dp[target] != -1) return dp[target];
        
        int ans = 0;
        for (int i : nums)
            if (target >= i)
                ans += helper(dp, nums, target - i);
        
        dp[target] = ans;
        return ans;
    }
}