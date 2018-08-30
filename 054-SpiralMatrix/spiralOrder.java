class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int rowMin = 0, colMin = 0, rowMax = matrix.length - 1, colMax = matrix[0].length - 1;
        /*
        Traverse right and increment rowMin, then traverse down and decrement colMax, 
        then traverse left and decrement rowMax, and finally traverse up and increment colMin.
        */
        while (rowMin <= rowMax && colMin <= colMax) {
            for (int j = colMin; j <= colMax; j++)
                res.add(matrix[rowMin][j]);
            rowMin++;
            for (int i = rowMin; i <= rowMax; i++)
                res.add(matrix[i][colMax]);
            colMax--;
            if (rowMin > rowMax || colMin > colMax) break;
            for (int j = colMax; j >= colMin; j--)
                res.add(matrix[rowMax][j]);
            rowMax--;
            for (int i = rowMax; i >= rowMin; i--)
                res.add(matrix[i][colMin]);
            colMin++;
        }
        return res;
    }
}