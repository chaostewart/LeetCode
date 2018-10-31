class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        // dp[i] stores the # of unique BST's that store values 1...i
        dp[0] = dp[1] = 1;  // where tree is empty or has only one node, # of unique trees is one
        
        for (int i = 2; i <= n; i++)
            // j is a value in 1...i is chosen to be the root of a BST that stores values 1...i
            for (int j = 1; j <= i; j++)
                // dp[j-1] is the # of unique BST's that store values 1...j-1 as the left subtree of root j
                // dp[i-j] is the # of unique BST's that store values j+1...i as the right subtree of root j
                dp[i] += dp[j-1] * dp[i-j];
        
        return dp[n];
    }
}
