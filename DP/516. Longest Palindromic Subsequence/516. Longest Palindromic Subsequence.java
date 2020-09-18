//https://www.youtube.com/watch?v=_nCsPn7_OgI&t=57s

public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i=0; i<n; i++){
            dp[i][i] = 1;
            for (int j=i-1; j>=0; j--){
                if (s.charAt(j)==s.charAt(i)){
                    dp[j][i] = dp[j+1][i-1]+2;
                }else{
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
                }
            }
        }
        return dp[0][n-1];
    }
    
    //REcursive
    class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        
        return helper(s, 0, n-1, memo);
    }
    public int helper(String s, int i, int j, int[][] memo){
        if (i>j) return 0;
        if (i==j) return 1;
        if (memo[i][j]>0) return memo[i][j];
        int ans = 0;
        if (s.charAt(i)==s.charAt(j)){
            ans = helper(s, i+1, j-1, memo)+2;
        }else{
            ans = Math.max(helper(s, i+1, j, memo), helper(s, i, j-1, memo));
        }
        memo[i][j]= ans;
        return ans;
    }
}
