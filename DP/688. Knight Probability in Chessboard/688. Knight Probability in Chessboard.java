class Solution {
    int[][] dirs = {{-1, -2},{-2, -1}, {-2, 1}, {-1, 2}, {1, 2},{2, 1},{2, -1},{1, -2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K+1];
        return helper(N, K, r, c, dp);
    }
    public double helper(int N, int K, int r, int c, double[][][] dp){
        if (r<0 || r>=N || c<0 || c>=N) return 0;     
        if (K==0) return 1;
        if (dp[r][c][K]!=0) return dp[r][c][K];
        
        double ans = 0;
        for (int[] dir:dirs){
            ans+=0.125*helper(N, K-1, r+dir[0], c+dir[1], dp);
        }
        
        dp[r][c][K]=ans;
        return ans;
    }
}

public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{-1, -2},{-2, -1}, {-2, 1}, {-1, 2}, {1, 2},{2, 1},{2, -1},{1, -2}};
        double[][] dp_prev = new double[N][N];
        double res = 0;
        dp_prev[r][c] = 1;
        for (int k=1; k<=K; k++){
            double[][] dp = new double[N][N];
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    for (int[] dir:dirs){
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (newRow<N && newRow>=0 && newCol<N && newCol>=0){
                            dp[newRow][newCol] += dp_prev[i][j]/8;
                        }
                    }
                }
            }
            dp_prev = dp;
        }
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                res += dp_prev[i][j];
            }
        }
        return res;
    }
