class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // the following converts the board to a 1D array
        int[] arr = new int[n * n];
        int r = n - 1, c = 0, index = 0, delta_c = 1;
        while (index < n * n) {
            arr[index++] = board[r][c];
            if (c == n - 1 && delta_c == 1 ) {
                delta_c = -1;
                r--;
            } else if (c == 0 && delta_c == -1) {
                delta_c = 1;
                r--;
            } else
                c += delta_c;        
        }
        
        boolean[] visited = new boolean[n * n];
        // stores index of quares to visie in each BFS round
        Queue<Integer> queue = new LinkedList<>();
        // push the index of first quare onto queue or push the destination of its ladder or snake
        int start = arr[0] > -1 ? arr[0] - 1 : 0;   
        queue.offer(start);
        visited[start] = true;
        // steps stores the answer
        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                int curr = queue.poll();
                if (curr == n * n - 1) 
                    return steps;
                
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n - 1); next++) {
                    int dest = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}