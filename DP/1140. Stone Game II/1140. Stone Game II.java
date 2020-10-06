class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] presum = new int[n];
        for (int i=n-1; i>=0; i--) {
            if (i==n-1) presum[i] = piles[i];
            else presum[i] = presum[i+1] + piles[i];
        }
        int[][] dp = new int[n][n];
        return helper(presum, 0, 1, dp);
    }
    public int helper(int[] presum, int s, int M, int[][] dp){
        if (s + 2*M >=presum.length) return presum[s];
        if (dp[s][M]>0) return dp[s][M];
        int take = 0, res = 0;
        for (int i=1; i<= 2*M; i++){
            take = presum[s] - presum[s+i];
            res = Math.max(res, take + presum[s+i] - helper(presum, s+i, Math.max(i, M), dp));
        }
        dp[s][M] = res;
        return res;
    }
}
