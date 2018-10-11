/*
DFS solution
Two visited boolean matrices, one for pacific one for atlantic. In the end, 
add the cell visited by both oceans to the result.
Since water can only flow from high/equal cell to low cell, 
mark the neighboor cell with height larger or equal to current cell as visited.
*/

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int j = 0; j < n; j++) {
            dfs(matrix, pVisited, 0, j, Integer.MIN_VALUE, dirs);
            dfs(matrix, aVisited, m - 1, j, Integer.MIN_VALUE, dirs);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pVisited, i, 0, Integer.MIN_VALUE, dirs);
            dfs(matrix, aVisited, i, n - 1, Integer.MIN_VALUE, dirs);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                if (pVisited[i][j] && aVisited[i][j])
                    res.add(new int[] {i, j});
        return res;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int height, int[][] dirs) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || height > matrix[i][j])
            return;
        visited[i][j] = true;
        for (int[] dir : dirs)
            dfs(matrix, visited, i + dir[0], j + dir[1], matrix[i][j], dirs);
        
    }
}