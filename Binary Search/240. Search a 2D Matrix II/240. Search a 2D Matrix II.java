/*
Time: O(m+n)
*/

//start from top right corner
public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix==null || m==0 || n==0) return false;
        int col = n-1, row = 0;
        while (col >= 0 && row < m){
            if (matrix[row][col]==target) return true;
            if (target < matrix[row][col]) col--;
            else row++;
        }
        return false;
    }
    
    
 //start from bottom left corner
 public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix==null || m==0 || n==0) return false;
        int col = 0, row = m-1;
        while (row >= 0 && col < n){
            if (matrix[row][col]==target) return true;
            if (target < matrix[row][col]) row--;
            else col++;
        }
        return false;
    }
