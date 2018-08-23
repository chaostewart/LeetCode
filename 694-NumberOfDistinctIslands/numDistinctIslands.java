class Solution {
    private int[][] grid;
    private boolean[][] seen;
    private List<Integer> shape;   // declare global variables so that private helper function can mutate them
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];    // record if a square has been touched by DFS
        Set<List<Integer>> shapeSet = new HashSet<>();      // shapeSet stores distinct island shapes
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !seen[row][col]) {
                    shape = new ArrayList<>();              // records the next island's shape/DFS path
                    DFS(row, col, 0);
                    if (!shape.isEmpty())
                        shapeSet.add(shape);         // if the shape of island is unseen, this new shape will be added to set
                }
            }
        }
        return shapeSet.size();
    }
    
    private void DFS(int r, int c, int path) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !seen[r][c]) {
            shape.add(path);
            seen[r][c] = true;
            DFS(r - 1, c, 1);   // up
            DFS(r, c + 1, 2);   // right
            DFS(r + 1, c, 3);   // down
            DFS(r, c - 1, 4);   // left
            shape.add(0);       // start and end of a path are labelled as '0'
        }
    }
}
