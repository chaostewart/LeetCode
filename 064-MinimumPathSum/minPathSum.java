class Solution {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int[] dp = new int[width];
        dp[0] = grid[0][0];
        for(int j = 1; j < width; j++)
            dp[j] = grid[0][j] + dp[j - 1];       
        
        for (int i = 1; i < grid.length; i++) 
            for (int j = 0; j < width; j++) {
                if (j > 0)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                else
                    dp[j] = grid[i][j] + dp[j];
            }
        
        return dp[width - 1];
                
    }
}