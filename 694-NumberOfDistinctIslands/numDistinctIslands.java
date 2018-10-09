class Solution {
    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];   // record if a square has been visited
        Set<List<Integer>> shapeSet = new HashSet<>();   // shapeSet stores distinct island shapes
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Integer> path = new ArrayList<>();    // records the next island's shape/DFS path
                    DFS(grid, visited, path, 0, i, j);
                    if (!path.isEmpty())     // if the shape of island is unseen, this new shape will be added to set
                        shapeSet.add(path);
                }
        return shapeSet.size();
    }
    
    private void DFS(int[][] grid, boolean[][] visited, List<Integer> path, int dir, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            path.add(dir);
            DFS(grid, visited, path, 1, i + 1, j);
            DFS(grid, visited, path, 2, i - 1, j);
            DFS(grid, visited, path, 3, i, j + 1);
            DFS(grid, visited, path, 4, i, j - 1);
            path.add(0);    // start and end of a path are labelled as '0'
        }
    }
}
