public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n+1][7];
        for (int i=0; i<6; i++) dp[1][i] = 1;
        dp[1][6] = 6;
        dp[0][6] = 1; //this is for the case when i - rollMax[j] ==1, so that i - rollMax[j] - 1 == 0
        
        for (int i=2; i<=n; i++){
            int total = 0;
            for (int j=0; j<6; j++){
                dp[i][j] = dp[i-1][6];
                if (i - rollMax[j] > 0){
                    int reduction = dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j];
                    dp[i][j] =  ((dp[i][j] - reduction) % mod + mod) % mod;
                }
                 dp[i][6] = (dp[i][6] + dp[i][j] % mod) % mod;  
            }
        }
        return dp[n][6];
    }
