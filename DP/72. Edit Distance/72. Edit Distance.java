//Time O(l1*l2)
//Space O(l1*l2)
public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for (int i=1; i<=m; i++){
            dp[i][0] = i;
        }
        for (int i=1; i<=n; i++){
            dp[0][i] = i;
        }
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
            
        }
        return dp[m][n];
    }

//Recursive
public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        for (int i=0; i<=l1; i++){
            for (int j=0; j<=l2; j++){
                dp[i][j] = -1;   
            }    
        }
        return minDistance(word1, word2,l1, l2, dp);
    }
    public int minDistance(String word1, String word2, int l1, int l2, int[][] dp){
        if (l1==0) return l2;
        if (l2==0) return l1;
        if (dp[l1][l2]>=0) return dp[l1][l2];
        
        int ans = 0;
        if (word1.charAt(l1-1)==word2.charAt(l2-1)){
                ans = minDistance(word1, word2, l1-1, l2-1, dp);
        }else{
                ans = minDistance(word1, word2, l1-1, l2-1, dp)+1;
                ans = Math.min(minDistance(word1, word2, l1-1, l2, dp)+1, ans);
                ans = Math.min(minDistance(word1, word2, l1, l2-1, dp)+1, ans);
        }
        
        dp[l1][l2] = ans;
        return ans;
    }
