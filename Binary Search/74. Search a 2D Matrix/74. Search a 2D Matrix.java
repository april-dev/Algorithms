
//First method use binary search by row first, then binary search by column. 
//Second method treats 2D matrix as a sorted list and then use binary search
//First complexity O(logm + logn) = O(logmn). second complexity is O(logmn) as well.

public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        if (n==0) return false;
        int left = 0, right = m-1;
        int rowIndex = -1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (matrix[mid][0]==target) return true;
            if (matrix[mid][0]<target){
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        //rowIndex = left==0? 0:(left-1); also works
        rowIndex = right < 0 ? 0 : right;
        
        left = 0;
        right = n-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (matrix[rowIndex][mid]==target) return true;
            if (matrix[rowIndex][mid]<target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
    
    
    public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int start = 0, rows = matrix.length, cols = matrix[0].length;
            int end = rows * cols - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[mid / cols][mid % cols] == target) {
                    return true;
                } 
                if (matrix[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
