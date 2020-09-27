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
