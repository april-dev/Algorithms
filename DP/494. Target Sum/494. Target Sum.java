public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n:nums) sum+=n;
        if (S > sum || S < -sum) return 0;
        
        int[][] dp = new int[nums.length+1][2*sum+1];
        dp[0][0+sum] = 1;
        for (int i=1; i<=nums.length; i++){
            for (int j=0; j<2*sum+1; j++){
                if (j-nums[i-1]>=0) dp[i][j] += dp[i-1][j-nums[i-1]];
                if (j+nums[i-1]<2*sum+1) dp[i][j] += dp[i-1][j+nums[i-1]];
            }
        }
        return dp[nums.length][sum+S];
    }


//O(2^N)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0, 0);
    }
    public int helper(int[]nums, int S, int sum, int idx){
        if (idx == nums.length) return sum==S? 1:0;
         return helper(nums, S, sum-nums[idx], idx+1) + helper(nums, S, sum+nums[idx], idx+1);      
    }
}

/*
                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)

Then this question is transformed to 416. Partition Equal Subset Sum.

*/
public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 

