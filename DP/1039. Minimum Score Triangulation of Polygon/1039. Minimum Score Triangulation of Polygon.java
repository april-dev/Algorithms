//DP
public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++){
            for (int i = 0; i + len <n; i++){
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i]*A[j]*A[k]);
                }
            }
        }
        return dp[0][n-1];
    }


//recursive + memo
public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        return helper(A, 0, n-1, dp);
    }
    public int helper(int[] A, int i, int j, int[][] dp){
        if (dp[i][j]!=0) return dp[i][j];
        int res = 0;
        for (int k = i+1; k<j; k++){
            res = Math.min(res == 0 ? Integer.MAX_VALUE : res, helper(A, i, k, dp) + helper(A, k, j, dp) + A[i]*A[j]*A[k]);
        }
        dp[i][j] = res;
        return res;
    }
