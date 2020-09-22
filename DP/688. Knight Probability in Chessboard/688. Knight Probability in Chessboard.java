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
