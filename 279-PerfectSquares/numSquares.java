class Solution {
    public int numSquares(int n) {
        /* sol 1: solve the problem as the coin change problem!
        // make coins
        List<Integer> sqrs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sqr = i * i;
            if (sqr <= n)
                sqrs.add(sqr);
            else break;            
        }
        // find the fewest number of coins
        int[] dp = new int[n + 1];
        int sum = 0;
        while (++sum <= n) {
            int min = -1;
            for (int sqr: sqrs) {
                if (sqr <= sum && dp[sum - sqr] != -1) {
                    int temp = dp[sum - sqr] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min); 
                }
            }
            dp[sum] = min;
        }
        return dp[n];
        */
        
        // sol 2: clean up the above code and save some space
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }		
        return dp[n];
    }
}