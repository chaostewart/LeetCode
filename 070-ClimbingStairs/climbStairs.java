class Solution {
    public int climbStairs(int n) {
        if (n <=0 ) return 0; // the number of ways should be zero.
        if (n == 1)  return 1;  // there is only way to climb the stair.
        if (n == 2)  return 2;  // there are two ways to climb the stairs. 
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) 
          dp[i] = dp[i-1] + dp[i - 2];
        /* 
            From the [n-1] point, we can take one single step to reach [n]. 
            From the [n-2] point, we could take two steps to get there. 
            There is NO overlapping between these two solution sets, because we differ in the final step.
        */
        
        return dp[n];
    }
}