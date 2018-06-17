class Solution {
    public int longestPalindromeSubseq(String s) {
        // 2nd DP problem
        int[][] dp = new int[s.length()][s.length()];   //initialized to zero's?
        // move from bottom right to top right
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;  // a char itself is a palindrom of length 1
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1] [j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][s.length() - 1];
        
    }
}