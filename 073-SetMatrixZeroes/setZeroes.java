class Solution {
    public void setZeroes(int[][] matrix) {
        // Use 1st row and 1st column to record that status of othe elems
        // Use 2 boolean variables to record the status of 1st row and col
        // Traverse the matrix twice, runtime: O(m*n)
        boolean row0 = false, col0 = false;
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix[0].length; j++) 
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true;
                    if (j == 0) col0 = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

        for (int i = 1; i < matrix.length; i++) 
            for (int j = 1; j < matrix[0].length; j++) 
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
 
        if (row0) 
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
 
        if (col0) 
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        
    }
}
