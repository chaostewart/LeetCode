class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // flip matrix about horizontal axis
        int upper = 0, lower = len - 1;
        while (upper < lower) {
            int[] temp = matrix[upper];
            matrix[upper] = matrix[lower];
            matrix[lower] = temp;
            upper++; lower--;
        }
        // flip matrix about "\" diagonal
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}