class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) 
            return 0;
        int[] dp = new int[amount + 1];   // dp[amount] stores the final answer
        
        int sum = 0;
        while(++sum <= amount) {
            int min = -1;    // default value is no solution to this 'sum' amount of money
            for(int coin : coins) {
                // value of sum is larger than coin value && previously value of (sum - coin) had a solution
                if (sum >= coin && dp[sum - coin] != -1) {   
                    int temp = dp[sum-coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                    // temp is either the first solution or a better solution
                }
            }
            dp[sum] = min;    // found the best solution for 'sum' money
        }
        return dp[amount];
    }
}