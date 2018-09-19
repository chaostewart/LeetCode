/*
- First, check the four border of the matrix. If there is a element is 'O', alter it and all its neighbor 'O' elements to '1'.
- Then ,alter all the 'O' to 'X'
- At last,alter all the '1' to 'O'
*/

class Solution {
    public void solve(char[][] board) {
        int i, j;
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        
        /* scan 4 borders, flip 'O' and connected inner 'O' to '1'*/
        for(i = 0; i < m; i++) {
            check(board, i, 0, m, n);   // j = 0, left column
            if(n > 1) 
                check(board, i, n - 1, m, n);    // j = n-1, right column
        }
        
        for(j = 1; j < n - 1; j++) {     //  i = 0, check top row excluding both ends
            check(board, 0, j, m, n);
            if(m > 1)                   // i = m - 1, check bottom row excluding both ends
                check(board, m - 1, j, m, n);
        }
        /* scan whole board, flip 'O' to 'X'*/
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
        
        /* scan whole board again, flip '1' to 'O'*/
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == '1')
                    board[i][j] = 'O';
    }
    
    /* DFS to flip 'O's on border and their inner connected 'O's to '1's */
    private void check(char[][] board, int i, int j, int m, int n) {
        if(board[i][j] == 'O') {
            board[i][j] = '1';
            check(board, Math.max(i - 1, 0), j, m, n);
            check(board, i, Math.max(j - 1, 0), m, n);
            check(board, Math.min(i + 1, m - 1), j, m, n);
            check(board, i, Math.min(j + 1, n - 1), m, n);
        }
    }
}