class Solution {
    private int rowNum;    // save grid map's dimensions to private int variables so that 
    private int colNum;     // they can be accessed by both functions in this class
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)     // default format for the special case
            return 0;
        rowNum = grid.length;
        colNum = grid[0].length;
        int count = 0;
        for (int r = 0; r < rowNum; r++) {          // traverse the grid row by row, col by col
            for (int c = 0; c < colNum; c++) {
                if (grid[r][c] == '1') {           // once find the start of a piece of land, do DFSMarking
                    count++;
                    DFSMarking(grid, r, c);
                }
            }
        }
        return count;   
    }
    
    // private function that serves the public function
    private void DFSMarking(char[][] grid, int row, int col) {
        // return if the search hits any of the edges or an elem which is (marked as) water
        if (row < 0 || col < 0 || row >= rowNum || col >= colNum || grid[row][col] == '0') 
            return;
        grid[row][col] = '0';    // mark the land as water because it's been counted
        DFSMarking(grid, row - 1, col);
        DFSMarking(grid, row + 1, col);
        DFSMarking(grid, row, col - 1);
        DFSMarking(grid, row, col + 1);
    }
}