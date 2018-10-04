class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int upper = 0, lower = n - 1;
        // flip matrix about horizontal axis
        while (upper < lower) {
            int[] temp = matrix[upper];
            matrix[upper] = matrix[lower];
            matrix[lower] = temp;
            upper++;
            lower--;
        }
        // flip matrix about "\" diagonal
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }
}
