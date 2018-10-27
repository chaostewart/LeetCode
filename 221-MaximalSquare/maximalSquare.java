class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1') {
                    int left = i-1 >= 0 ? dp[i-1][j] : 0;
                    int up = j-1 >= 0 ? dp[i][j-1] : 0;
                    int upleft = i-1 >= 0 && j-1 >= 0 ? dp[i-1][j-1] : 0;
                    dp[i][j] = 1 + Math.min(upleft, Math.min(up, left));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }           
        return maxLen * maxLen;
    }
}


class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        // dp[r][c] stores the length of a square of which its bottom right cell is at (r, c)
        int[][] dp = new int[rows + 1][cols + 1];
   
        int maxEdge = 0;      
        for(int r = 1; r <= rows; r++)
            for(int c = 1; c <= cols; c++)
                if(matrix[r - 1][c - 1] == '1') {
                    /* 
                       Top, Left, and Top Left decides the size of the square. 
                       If all of them are same, then the size of square increases by 1. 
                       If they're not same, they can increase by 1 to the minimal square.
                    */
                    dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                    maxEdge = Math.max(maxEdge, dp[r][c]);
                }
      
      return maxEdge * maxEdge;  
    }
}
