public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[n][n+2];
        for (int[] arr:dp) Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i=1; i<n+1; i++){
            dp[0][i] = A[0][i-1];
        }
        
        for (int i=1; i<n; i++){
            for (int j=0; j<n; j++){
                int min = Math.min(dp[i-1][j], dp[i-1][j+1]);
                min = Math.min(min, dp[i-1][j+2]);
                dp[i][j+1] = min+A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i=1; i<n+1; i++){
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
