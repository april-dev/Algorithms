public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        
        //int[][] dp = new int[n][m];
        for (int i=1;i<n;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for (int j=1;j<m;j++){
            grid[0][j]+=grid[0][j-1];
        }
        
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                
                
            }
        }
        return grid[n-1][m-1];
    }
    
    //O(n) space
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i=1; i<n; i++){
            dp[i]=dp[i-1]+grid[0][i];
        }
        for (int i=1; i<m; i++){
            dp[0] = dp[0]+grid[i][0];
            for (int j=1; j<n; j++){
                dp[j]= Math.min(dp[j], dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];

    }
