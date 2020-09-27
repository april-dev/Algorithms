public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        
        for (int i = 1; i <= arr.length; i++){
            int curMax = 0;
            for (int j = 1; j <= k && j <= i; j++){
                curMax = Math.max(curMax, arr[i-j]);
                dp[i] = Math.max(dp[i], dp[i-j] + curMax * j);
            }
        }
        return dp[arr.length];
    }

class Solution {
    private int dfs(int[] A, int K, int start, int[] dp) {
        int n = A.length;
        if (start >= n) return 0;
        if (dp[start] != 0) {
            return dp[start];
        }
        int maxSum = 0, maxEle = 0;
        for (int i = start; i < Math.min(n, start + K); i++) {
            maxEle = Math.max(maxEle, A[i]);
            maxSum = Math.max(maxSum, maxEle * (i - start + 1) + dfs(A, K, i + 1, dp));
        }
        dp[start] = maxSum;
        return maxSum;
    }
    
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        return dfs(A, K, 0, dp);
    }
}
