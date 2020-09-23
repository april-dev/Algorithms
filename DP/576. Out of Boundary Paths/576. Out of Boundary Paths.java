class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
    int mod = 1000000000+7;
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[m][n][N+1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int kk = 0; kk < N+1; kk++) {
                    dp[ii][jj][kk] = -1;
                }
            }
        }
        return helper(m, n, N, i, j, dp);
    }
    public int helper(int m, int n, int N, int i, int j, int[][][] dp){
        if (i<0 || i>=m || j<0 || j>=n && N>=0) return 1;
        if (N==0) return 0;
        if (dp[i][j][N]!=-1) return dp[i][j][N];
        int ans = 0;
        for (int[] dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            ans = (ans + helper(m, n, N-1, x, y, dp)%mod)%mod;
        }
        dp[i][j][N] = ans%mod;
        return ans%mod;
    }    
}

//DP[i][j][k] stands for how many possible ways to walk into cell j,k in step i, DP[i][j][k] only depends on DP[i - 1][j][k], 
//so we can compress 3 dimensional dp array to 2 dimensional.
public int findPaths(int m, int n, int N, int r, int c) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
        int mod = 1000000000+7;
        int[][] dp_prev = new int[m][n];
        int res = 0;
        dp_prev[r][c] = 1;
        for (int step=0; step<N; step++){
            int[][] dp = new int[m][n];
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    for (int[] dir:dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x<0 || x>=m || y<0 || y>=n){
                             res = (res + dp_prev[i][j])%mod;
                        }else{
                            dp[x][y] = (dp[x][y] + dp_prev[i][j])%mod;
                        }
                    }
                }
            }
            dp_prev = dp;
        }
        return res;
    }
