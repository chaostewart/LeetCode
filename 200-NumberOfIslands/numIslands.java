class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == '1') {
                    res++;
                    DFS(grid, i, j, m, n);  // once find the start of a piece of land, do DFSMarking
                }
        return res;
    }
    // private function that recursively does DFS until reaching all the edges of one island while updating the grid
    private void DFS(char[][] grid, int r, int c, int m, int n) {
        // return without updating the grid if the search hits any of the edges or an elem which is (marked as) water
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') return;
        grid[r][c] = '0';       // mark the land as water as it's been counted
        DFS(grid, r + 1, c, m, n);
        DFS(grid, r - 1, c, m, n);
        DFS(grid, r, c + 1, m, n);
        DFS(grid, r, c - 1, m, n);
    }
}
