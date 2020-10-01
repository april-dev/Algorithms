class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[k+1][n+1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], n);
        for (int i = 1; i <= n; i++){
            dp[1][i] = minChange(s, 0, i-1);
        }
        for (int group = 2; group <= k; group++){
            for (int i = group; i <= n; i++){
                for (int j = group-1; j < i; j++){
                    dp[group][i] = Math.min(dp[group][i], dp[group-1][j] + minChange(s, j, i-1));
                }
            }
        }
        return dp[k][n] == n ? -1 : dp[k][n];
        
    }
    public int minChange(String s, int i, int j){
        int c = 0;
        while (i < j){
            if (s.charAt(i++)!=s.charAt(j--)) c++;            
        }
        return c;
    }
}

class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[k+1][n+1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        return helper(s, k, dp, n);
        
    }
    public int helper(String s, int k, int[][] dp, int n){
        if (dp[k][n]!=Integer.MAX_VALUE) return dp[k][n];
        if (k==1) return minChange(s, 0, n-1);
        for (int i=k-1; i<n; i++){
            dp[k][n] = Math.min(dp[k][n], helper(s, k-1, dp, i) + minChange(s, i, n-1));
        }
        return dp[k][n];
    }
     public int minChange(String s, int i, int j){
        int c = 0;
        while (i < j){
            if (s.charAt(i++)!=s.charAt(j--)) c++;            
        }
        return c;
    }
}
