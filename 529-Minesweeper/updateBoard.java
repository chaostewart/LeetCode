class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
        // sol 2: DFS
        int rowNum = board.length, colNum = board[0].length;
        int row = click[0], col = click[1];
        
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= rowNum || c < 0 || c >= colNum) continue;
                    if (board[r][c] == 'M') count++;
                }
            }
            
            if (count > 0) {
                board[row][col] = (char)(count + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= rowNum || c < 0 || c >= colNum) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }
        return board;
        // sol 1: BFS
        /*
        int rowNum = board.length, colNum = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            // case 1: cell is a mine
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
                //return board;
            } else {
                // check if it is case 3
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;   // skip the current inspected cell
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= rowNum || c < 0 || c >= colNum) continue;
                        if (board[r][c] == 'M') count++;
                    }
                }
                // case 3: cell has adjacent mines
                if (count > 0) {
                    board[row][col] = (char)(count + '0'); 
                } else {   // case 2: no mines, revealing surrounding blank cells recursively
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= rowNum || c < 0 || c >= colNum) continue;
                            if (board[r][c] == 'E') {
                                queue.add(new int[] {r, c});
                                board[r][c] = 'B';
                            }
                        }
                    }
                    
                }
            }
        }
        return board;
        */
        
    }
}