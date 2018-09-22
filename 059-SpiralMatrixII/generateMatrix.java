class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];       
        int rowMin = 0, colMin = 0, rowMax = n - 1, colMax = n - 1;
        int num = 1;
        while (rowMin <= rowMax && colMin <= colMax) {
            for (int j = colMin; j <= colMax; j++)
                matrix[rowMin][j] = num++;
            rowMin++;
            for (int i = rowMin; i <= rowMax; i++)
                matrix[i][colMax] = num++;
            colMax--;
            if (rowMin > rowMax || colMin > colMax) break;
            for (int j = colMax; j >= colMin; j--)
                matrix[rowMax][j] = num++;
            rowMax--;
            for (int i = rowMax; i >= rowMin; i--)
                matrix[i][colMin] = num++;
            colMin++;
        }
        return matrix;
    }
}