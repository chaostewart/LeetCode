// Time & space: O(n ^ 2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j] stores the length of longest palindromic subsequence in the substring b/w indices [i, j] inclusive of s 
        int[][] dp = new int[s.length()][s.length()];  
        // move from bottom to top, starting from the diagonal of each row
        // only update values in the top right triangle area of the 2D matrix
        for (int i = s.length() - 1; i >= 0; i--) {
            // a char itself is a palindrome of length 1
            dp[i][i] = 1;               
            // update values for each char after char i
            for (int j = i + 1; j < s.length(); j++) {
                // if char j == char i, then palindromic subsequence of substring [i + 1, j - 1] gets expanded by 2
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1] [j - 1] + 2;
                // if not, the longest length in range [i, j] is the max of [i, j - 1] & [i + 1, j]
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][s.length() - 1];
        
    }
}
