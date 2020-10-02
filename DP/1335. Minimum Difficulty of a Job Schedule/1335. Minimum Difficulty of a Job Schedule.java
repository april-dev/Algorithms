class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[d+1][n+1];
        for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i=1; i<=n; i++) dp[1][i] = findMax(jobDifficulty, 0, i-1);
        for (int group=2; group<=d; group++){
            for (int i = group; i<=n; i++){
                for (int j = group - 1; j<i; j++){
                    dp[group][i] = Math.min(dp[group][i], dp[group-1][j]+findMax(jobDifficulty, j, i-1));
                }
            }
        }
        return dp[d][n]==Integer.MAX_VALUE?-1:dp[d][n];
    }
    public int findMax(int[] jobDifficulty, int i, int j){
        int max = 0;
        for (int c=i; c<=j; c++){
            max = Math.max(max, jobDifficulty[c]);
        }
        return max;
    }
    
}

//optimize by calculating running max
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n<d) return -1;
        int[][] dp = new int[d+1][n+1];
        
        for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[1][0] = 0;
        
        for (int i=1; i<=n; i++) dp[1][i] = Math.max(dp[1][i-1], jobDifficulty[i-1]);
        for (int group=2; group<=d; group++){
            for (int i = group; i<=n; i++){
                int max = 0;
                for (int j = i - 1; j >= group-1; j--){
                    max = Math.max(max, jobDifficulty[j]);
                    dp[group][i] = Math.min(dp[group][i], dp[group-1][j]+max);
                }
            }
        }
        return dp[d][n]==Integer.MAX_VALUE?-1:dp[d][n];
    }
}
