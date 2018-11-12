class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;                              // dp[0] means there's only one way to decode an empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;     // dp[1] means there's at most one way to decode a string of size 1
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (oneDigit != 0)
                dp[i] += dp[i - 1];
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];       
        }
        return dp[n];
    }
}
