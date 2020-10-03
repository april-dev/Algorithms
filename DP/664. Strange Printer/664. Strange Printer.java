
//bottom up
public int strangePrinter(String s) {
        int n = s.length();
        if (n==0) return 0;
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) dp[i][i] = 1;
        
        for (int len=1; len<=n; len++){
            for (int i=0; i<n-len; i++){
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<j; k++){
                    int turn = dp[i][k] + dp[k+1][j];
                    if (s.charAt(k)==s.charAt(j)) dp[i][j] = Math.min(dp[i][j], turn-1);
                    else dp[i][j] = Math.min(dp[i][j], turn);
                }
            }
        }
        return dp[0][n-1];
    }
    
    
//top down
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n==0) return 0;
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) dp[i][i] = 1;
        return helper(s, 0, n-1, dp);
    }
    public int helper(String s, int i, int j, int[][] dp){
        if (i>j) return 0;
        if (dp[i][j]>0) return dp[i][j];
        
        int res = s.length()+1;
        for (int k=i; k<j; k++){
            int turn = helper(s, i, k, dp) + helper(s, k+1, j, dp);
            if (s.charAt(k)==s.charAt(j)) res = Math.min(res, turn-1);
            else res = Math.min(res, turn);
        }
        dp[i][j] = res;
        return res;
    }
}
