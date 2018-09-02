class Solution {
    /*
    sol 1: DFS approach
    Time complexity : O(mn). Complete traversal of maze will be done in the worst case. 
    Here, m and n refers to the number of rows and coloumns of the maze.
    Space complexity : O(mn). visited array of size m*n is used.
    */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]])
            return false;
        if (destination[0] == start[0] && destination[1] == start[1])
            return true;
        visited[start[0]][start[1]] = true;
        int u = start[0] - 1, d = start[0] + 1, l = start[1] - 1, r = start[1] + 1;
        // up, down, left, righta
        while (u >= 0 && maze[u][start[1]] == 0)
            u--;
        if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
            return true;
        
        while (d < maze.length && maze[d][start[1]] == 0)
            d++;
        if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
            return true;
        
        while (l >= 0 && maze[start[0]][l] == 0)
            l--;
        if (dfs(maze, new int[] { start[0], l + 1}, destination, visited))
            return true;
        
        while (r < maze[0].length && maze[start[0]][r] == 0)
            r++;
        if (dfs(maze, new int[] { start[0], r - 1}, destination, visited))
            return true;
        
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