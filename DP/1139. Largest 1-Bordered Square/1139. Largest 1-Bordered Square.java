 public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] hor = new int[m][n];
        int[][] ver = new int[m][n];
        int max = 0;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    hor[i][j] = j==0? 1: hor[i][j-1]+1;
                    ver[i][j] = i==0? 1: ver[i-1][j]+1;
                }
            }  
        }
        
        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                int small = Math.min(hor[i][j], ver[i][j]);
                while (small>max){
                    if (hor[i-small+1][j]>=small && ver[i][j-small+1]>=small) max = small;
                    small--;
                }  
            }
        }        
        return max*max;
    }
