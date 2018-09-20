class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        // first, push all gates to queue
        for (int i = 0; i < rooms.length; i++) 
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0)
                    queue.add(new int[] {i, j});

        int[][] dirs = new int[][] {{1, 0, -1, 0}, {0, 1, 0, -1}};   // 4 directions
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // inspect curr rooms neighbors
            for (int i = 0; i < dirs[0].length; i++) {
                int nr = curr[0] + dirs[0][i];
                int nc = curr[1] + dirs[1][i];
                // the neighbor is out of boundary, a wall, a gate, or has been assigned a distance value
                // skip it, otherwise, push it onto queue
                if (nr < 0 || nr >= rooms.length || nc < 0 || nc >= rooms[0].length || rooms[nr][nc] != Integer.MAX_VALUE)
                    continue;
                rooms[nr][nc] = rooms[curr[0]][curr[1]] + 1;
                queue.add(new int[] {nr, nc});
            }
        }
    }
}