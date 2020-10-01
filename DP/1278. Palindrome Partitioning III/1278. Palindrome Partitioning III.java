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

//cost function(i.e., minChange) can also be represented using a dp matrix. Time complexity remains the same. O(n^2*k)
class Solution {
public:
  int palindromePartition(string s, int K) {
    const int n = s.length();    
    vector<vector<int>> cost(n, vector<int>(n));
    for (int l = 2; l <= n; ++l)
      for (int i = 0, j = l - 1; j < n; ++i, ++j)
        cost[i][j] = (s[i] != s[j]) + cost[i + 1][j - 1];
    
    vector<vector<int>> dp(n, vector<int>(K + 1, INT_MAX / 2));
    for (int i = 0; i < n; ++i) {      
      dp[i][1] = cost[0][i];
      for (int k = 2; k <= K; ++k)
        for (int j = 0; j < i; ++j)
          dp[i][k] = min(dp[i][k], dp[j][k - 1] + cost[j + 1][i]);        
    }
    return dp[n - 1][K];
  }
};
