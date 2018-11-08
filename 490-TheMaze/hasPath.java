class Solution {
    /*
    sol 1: DFS approach
    Time complexity : O(mn). Complete traversal of maze will be done in the worst case. 
    Here, m and n refers to the number of rows and coloumns of the maze.
    Space complexity : O(mn). visited array of size m*n is used.
    */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{1, 0, -1, 0}, {0, 1, 0, -1}};
        return DFS(maze, start, destination, visited, dirs);
    }
    
    private boolean DFS (int[][] maze, int[] start, int[] dest, boolean[][] visited, int[][] dirs) {
        // cell has been visited
        if (visited[start[0]][start[1]])
            return false;
        // destination has been reached
        if (start[0] == dest[0] && start[1] == dest[1])
            return true;
        // mark cell as visited
        visited[start[0]][start[1]] = true;
        // DFS in 4 directions
        for (int i = 0; i < dirs[0].length; i++) {
            int nr = start[0], nc = start[1];
            // keep moving towards one direction and hitting wall
            while (nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc] == 0) {
                nr += dirs[0][i];
                nc += dirs[1][i];
            }
            // retreat by one step to stand on an empty cell
            if (DFS(maze, new int[] {nr - dirs[0][i], nc - dirs[1][i]}, dest, visited, dirs))
                return true;
        }
        return false;
     }
    

    /*
    sol 2: BFS approach, slower than DFS
    Time complexity : O(mn). Complete traversal of maze will be done in the worst case. 
    Here, m and n refers to the number of rows and coloumns of the maze.
    Space complexity : O(mn). visited array of size m*n is used and queue size can grow upto m*n in worst case.
    */
    /*
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
    */
}
