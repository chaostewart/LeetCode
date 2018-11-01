class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int perim = 0;
        
        for (int i  =0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                if (grid[i][j] == 1) {
                    //top border
                    if (i == 0 || grid[i-1][j] == 0)
                        perim++;
                    //bottom border
                    if (i == m-1 || grid[i+1][j] == 0)
                        perim++;
                    // left border
                    if (j == 0 || grid[i][j-1] == 0)
                        perim++;
                    // right border
                    if (j == n-1 || grid[i][j+1] == 0)
                        perim++;
                }

        return perim;
    }
}