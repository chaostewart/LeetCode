class Solution {
    public int findLongestChain(int[][] pairs) {
        // 3rd dp problem:
        
         
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);  // have to sort first
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);   // longest len is at least 1
        for (int i = 0; i < dp.length; i++) {   // i iterates thru sorted pairs 
            for (int j = 0; j < i; j++)    // j compairs pairs before i with i and assign max len up to current point
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
        }
        return dp[pairs.length - 1];
       
        /*
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        int ans = 0;
        for (int x: dp) if (x > ans) ans = x;
        return ans;
        */
    }
}