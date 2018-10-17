// Knapsack problem, time: O(m * n), space: O(m)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) 
            for (int i = coin; i <= amount; i++) 
                dp[i] += dp[i-coin];

        return dp[amount];      
    }
}

/*
input amount = 5, coints = [1, 2, 5]
after initialization:
dp = 1, 0, 0, 0, 0, 0

coin = 2:
dp = 1, 0, 1, 0, 1, 0

coin = 1:
dp = 1, 1, 2, 2, 3, 3

coin = 5:
dp = 1, 1, 2, 2, 3, 4
*/