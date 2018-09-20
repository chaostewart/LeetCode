class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*  
        // create a 2D dp array
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++)
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        
        for (int i = m - 2; i >= 0; i--) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++)
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        }
        return dp[0][0];
        */
        // create a 1D dp array
        if (triangle == null || triangle.isEmpty()) 
            return 0;        
        int rows = triangle.size();
        int[] dp = new int[rows + 1];      
        for (int i = rows - 1; i >= 0 ; i--) {
            List<Integer> rowNodes = triangle.get(i);
            for (int j = 0; j <= i; j++)
                dp[j] = rowNodes.get(j) + Math.min(dp[j], dp[j + 1]);
        }   
        return dp[0];
    }
}