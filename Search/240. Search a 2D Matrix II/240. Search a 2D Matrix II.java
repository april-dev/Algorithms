
//can also start from bottom left
public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        int col=n-1, row = 0;
        while (col>=0 && row<m){
            if (matrix[row][col]==target) return true;
            else if (matrix[row][col]<target) row++;
            else col--;
            
        }
        return false;
        
    }
