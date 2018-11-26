// same idea, latest practice
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] array = new int[n * n];
        int idx = 0, delta = 1, j = -1;
        for (int i = n-1; i >=0; i--) {
            if (j == -1)
                delta = 1;     
            else if (j == n)
                delta = -1;
            j += delta;
            while (j >=0 && j < n) {
                array[idx] = board[i][j];
                idx++;
                j+= delta;
            }     
        }
        //for (int i : array)
            //System.out.println(i);
        int res = 0;
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n*n - 1)
                    return res;
                for (int i = 1; i <= 6; i++) {
                    int newIdx = curr + i;
                    if (newIdx < n*n) {
                        if (array[newIdx] != -1)
                            newIdx = array[newIdx] - 1;
                        if (!visited.contains(newIdx)) {
                            visited.add(newIdx);
                            // System.out.println(newIdx);
                            queue.add(newIdx);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}

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
