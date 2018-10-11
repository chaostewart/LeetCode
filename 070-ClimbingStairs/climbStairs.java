// turns out there's no special test cases such as n = 0 or 1 or 2..
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}


class Solution {
    public int climbStairs(int n) {
        if (n == 1)  return 1;  // there is only way to climb the stair.
        if (n == 2)  return 2;  // there are two ways to climb the stairs. 
        
        int[] dp = new int[n + 1];
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
