/*
1. Since we have to cut trees in order of their height, we first put trees (int[] {row, col, height}) into a priority queue and sort by height.
2. Poll each tree from the queue and use BFS to find out steps needed.

The worst case time complexity could be O(m^2 * n^2) (m = number of rows, n = number of columns) since there are m * n trees and for each BFS worst case time complexity is O(m * n) too.
*/

class Solution {
    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        //if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (forest.get(i).get(j) > 1) 
                    pq.add(new int[] {i, j});

        int[] start = new int[2];  // initialized as {0, 0}
        int res = 0;
        while (!pq.isEmpty()) {
            int[] dest = pq.poll();  // poll the next tree to cut
            int step = minStep(forest, start, dest);   // steps needed to walk to tree from current start

            if (step < 0) return -1;
            res += step;

            start[0] = dest[0];
            start[1] = dest[1];
        }

        return res;
    }

    private int minStep(List<List<Integer>> forest, int[] start, int[] dest) {
        int m = forest.size(), n = forest.get(0).size();
        int step = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == dest[0] && curr[1] == dest[1]) 
                    return step;

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n 
                        || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }

        return -1;
    }
}