public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] m = new int[n][n];
        for (int i=0; i<n; i++){
            m[i][i] = arr[i];
            for (int j=i+1; j<n; j++){
                m[i][j] = Math.max(m[i][j-1], arr[j]);
            }
        }
        for (int len = 1; len<n; len++){
            for (int i=0; i+len<n; i++){
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + m[i][k]*m[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
    
 //Stack Solution
 //See stack
