public int longestCommonSubsequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    
    //Recursive + Memo
    public int longestCommonSubsequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m+1][n+1];
        for (int i=0; i<=m; i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(word1, word2, m, n, memo);
    }
    public int helper(String word1, String word2, int l1, int l2, int[][] memo){
        if (l1==0 || l2==0) return 0;
        if (memo[l1][l2]>=0) return memo[l1][l2];
        int ans = 0;
        if (word1.charAt(l1-1)==word2.charAt(l2-1)){
            ans = helper(word1, word2, l1-1, l2-1, memo)+1;
        }else{
            ans = Math.max(helper(word1, word2, l1-1, l2, memo), helper(word1, word2, l1, l2-1, memo));
        }
        memo[l1][l2] = ans;
        return ans;
    }
