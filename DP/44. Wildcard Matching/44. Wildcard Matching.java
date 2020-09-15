 //From Brute force to Bottom-up DP
 //https://leetcode.com/problems/wildcard-matching/discuss/370736/Detailed-Intuition-From-Brute-force-to-Bottom-up-DP
 
 public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for (int i=1; i<=n; i++){
            if (dp[0][i-1]==true && p.charAt(i-1)=='*')dp[0][i] = true;
        }
        
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];  
                }
            }
        }
        return dp[m][n];
    }
    
    
