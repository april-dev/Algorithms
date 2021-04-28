public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(steps,arrLen);  
        long[][] dp = new long[steps+1][maxPos+1];  //dp[i][j]代表第i步后，位置在j，有多少种走法
        dp[0][0]=1; 
        for(int i = 1; i <= steps; i++) { 
            for(int j = 0; j < maxPos; j++) {
              //第i步的情况由第i-1步情况得到，三种情况：静止在原地 + 从j+1往回跳一步的情况 + 从j-1向前跳一步的情况
                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1] + (j>0?dp[i-1][j-1]:0))%1000000007;
            }
        }
        
        return (int)dp[steps][0];        
    }
    
/*
The array size can be larger than the number of steps. We can ingore array elements greater than steps / 2, as we won't able to go back to the first element from there.

The key observation is that we can prune all the positions where i>steps as we can never reach 0 in that case.
We can now use memoization to cache all our answers, the only thing we need to worry about is memory which can be solved by using the 
observation i>steps will return 0 which means i will never exceed steps/2 due to pruning.
*/
class Solution {
    long mod = (int) 1e9+7;
    public int numWays(int steps, int arrLen) {
        long[][] dp = new long[steps+1][steps/2+1];
        for (long[] d:dp) Arrays.fill(d, -1);
        return (int)helper(steps, arrLen, dp, 0);
    }
    public long helper(int steps, int arrLen, long[][] dp, int idx){
        if (steps==0 && idx==0) return 1;
        if (idx<0 || idx>=arrLen || steps==0 || idx>steps) return 0;
        if (dp[steps][idx]!=-1) return dp[steps][idx];
        long res = 0;
        res = (res+helper(steps-1, arrLen, dp, idx-1))%mod;
        res = (res+helper(steps-1, arrLen, dp, idx+1))%mod;
        res = (res+helper(steps-1, arrLen, dp, idx))%mod;
        dp[steps][idx] = res%mod;
        return dp[steps][idx];
    }
}
