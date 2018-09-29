class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        // This genius algo. starts the search from top right!!  Time complexity is O(m + n)
        // traversing a row in descending order rules out other possibilities of finding target in a row
        // starting the search of target from bottom left would work too
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) 
                return true;
            else if (target < matrix[row][col])  // move towards left if target < current number
                col--;
            else       // move downwards if target > current number
                row++;
        }
        return false;   // while loop condition cannot be met anymore, fail to find target
    }
}
