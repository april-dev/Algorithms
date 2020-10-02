public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[1][0] = 0;
        for (int i=1; i<=n; i++){
            dp[1][i] = dp[1][i-1] + nums[i-1];
        }
        
        for (int k=2; k<=m; k++){
            for (int i=k; i<=n; i++){
                int sum = 0;
                for (int j=i-1; j>=k-1; j--){
                    sum += nums[j];
                    dp[k][i] = Math.min(dp[k][i], Math.max(dp[k-1][j], sum));
                }
            }
        }
        return dp[m][n];
    }
    
    //Alternative solution, IN the solution above, we calcuate running sum for each j, however this information was already stored in the dp[1][i].
    //Note that the order of traversal is different. In solution above, we traverse j backward from right to left, whereas j is traversed from left to right in solution below.
    
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[1][0] = 0;
        for (int i=1; i<=n; i++){
            dp[1][i] = dp[1][i-1] + nums[i-1];
        }
        
        for (int k=2; k<=m; k++){
            for (int i=k; i<=n; i++){
                int sum = 0;
                for (int j=k-1; j<i; j++){
                    sum += nums[j];
                    dp[k][i] = Math.min(dp[k][i], Math.max(dp[k-1][j], dp[1][i]-dp[1][j]));
                }
            }
        }
        return dp[m][n];
    }
