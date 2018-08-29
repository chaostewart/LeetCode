class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[0].length; c++)
                if(exist(board, r, c, word, 0))
                    return true;
        
        return false;
    }
    
    private boolean exist(char[][] board, int r, int c, String word, int i){
        if(i == word.length()) return true;   // all chars in word has been found
        // index out of bound OR char not found
        if(r >= board.length || r < 0 || c < 0 || c >= board[0].length || board[r][c] != word.charAt(i))
            return false;
        //  board[r][c] == word.charAt(i), char is found
        board[r][c] = '*';    // add a mask to original char to avoid being searched again
        boolean res = exist(board, r - 1, c, word, i + 1) || 
                      exist(board, r, c - 1, word, i + 1) ||
                      exist(board, r, c + 1, word, i + 1) || 
                      exist(board, r + 1, c, word, i + 1);
        board[r][c] = word.charAt(i);   // replace original char back to board
        return res;
    }
}