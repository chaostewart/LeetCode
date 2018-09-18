/*
Value       [2nd bit | 1st bit]        [next state, current state]
---------------------------------------------------------------------
  0                  00                [dead (next), dead (current)]
  1                  01                [dead (next), live (current)]  
  2                  10                [live (next), dead (current)]  
  3                  11                [live (next), live (current)] 
  
- In the beginning, every cell is either 00 or 01. 
    So don't need to make changes for [dead (next), dead (current)] or [dead (next), live (current)] 
- count # of neighbors of each pixel using its 1st bit, i.e. board[i][j] & 1
- update the value of board[i][j] which records its next state in the 2nd bit
- To get the next state, by doing board[i][j] >> 1 on all pixels
*/

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) {
                int lives = countLiveNeighbors(board, m, n, i, j);
                // we only care about when the 2nd bit becomes 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3)
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11               
                else if (board[i][j] == 0 && lives == 3) 
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10      
            }
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                board[i][j] >>= 1;  // Get the 2nd state.

    }

    private int countLiveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) 
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) 
                lives += board[x][y] & 1;

        lives -= board[i][j] & 1;
        return lives;
    }
}