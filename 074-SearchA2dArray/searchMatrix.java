class Solution {
    
    /*
    Use binary search.
    n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
    an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) 
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / cols][mid % cols] == target) 
                return true;
            if (matrix[mid / cols][mid % cols] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;        
    }
}