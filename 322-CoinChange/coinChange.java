class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];     // dp[amount] stores the final answer
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) 
            for (int i = 1; i <= amount; i++) 
                // value of amount is larger than coin value && previously value of (i - coin) had a solution
                if (coin <= i && dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        /*
        if (amount < 1) 
            return 0;
        int[] dp = new int[amount + 1];      
        int sum = 0;
        while(++sum <= amount) {
            int min = -1;    // default value is no solution to this 'sum' amount of money
            for(int coin : coins)
                
                if (sum >= coin && dp[sum - coin] != -1) {   
                    int temp = dp[sum-coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                    // temp is either the first solution or a better solution
                }
            dp[sum] = min;    // found the best solution for 'sum' money
        }
        return dp[amount];
        */
    }
}
