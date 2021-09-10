public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+2);
        dp[0] = 0;
        for(int i=0; i<ranges.length; i++){
            int left = Math.max(0, i-ranges[i]);
                int right = Math.min(i+ranges[i], n);
            for (int j=left+1; j<=right; j++){
                
                dp[j] = Math.min(dp[j], dp[left]+1);
            }
        }
        return dp[n]==n+2?-1:dp[n];
    }
