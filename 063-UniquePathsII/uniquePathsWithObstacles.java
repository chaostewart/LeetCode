class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;   // set initial value, at the start point, #paths = 1
        for (int[] row : obstacleGrid)    // scan each row
            for (int j = 0; j < width; j++) {      // scan each col of each row
                if (row[j] == 1)               // if current cell is an obstable, no paths throught this cell
                    dp[j] = 0;
                else if (j > 0)                // excluding the first cell of each row, update other cells
                    /*
                    dp[j] += dp[j - 1] ==> dp[j] = dp[j] + dp[j - 1];
                    which is new dp[j] = old dp[j] + dp[j-1]
                    which is current cell = top cell + left cell
                    */
                    dp[j] += dp[j - 1];
            }
        return dp[width - 1]; 
    }
}