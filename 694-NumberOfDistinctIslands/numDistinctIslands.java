class Solution {
    
    int[][] grid;
    boolean[][] seen;
    List<Integer> shape;         // declare global variables so that private helper function can mutate them
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];     // record if a square has been touched 
        Set shapeSet = new HashSet<ArrayList<Integer>>();    // store distinct shape paths
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                shape = new ArrayList<>();    // records the next islands DFS path <==> its shape
                DFS(row, col, 0);
                if (!shape.isEmpty()) {
                    shapeSet.add(shape);    // if this island is unseen shape will be recorded
                }
            }
        }
        return shapeSet.size();
    }
    
    private void DFS(int r, int c, int path) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !seen[r][c]) {
            shape.add(path);
            seen[r][c] = true;
            DFS(r + 1, c, 1); // down
            DFS(r - 1, c, 2); // up
            DFS(r, c + 1, 3); // right
            DFS(r, c - 1, 4); // left
            shape.add(0);   // don't understand why this is needed
        }
        
    }
}