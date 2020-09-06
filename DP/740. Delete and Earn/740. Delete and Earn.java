public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] value = new int[n];
        for (int num:nums){
            value[num]+=num;
        }
        
        int[] dp = new int[10002];
        dp[0]=0;
        dp[1]=value[0];
        for (int i=1;i<value.length;i++){
            dp[i+1]=Math.max(dp[i-1]+value[i],dp[i]);
        }
        
        return dp[10001];
    }
