public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1; i<=target; i++){
            for(int num:nums){
                if (i-num>=0) dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }

//Top down DP
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return helper(nums, target, dp);
    }
    public int helper(int[] nums, int target, int[] dp){
        if (target<0) return 0;
        if (target==0) return 1;
        if (dp[target]!=-1) return dp[target];
        int ans = 0;
        for (int num:nums){
            ans += helper(nums, target-num, dp);
        }
        dp[target] = ans;
        return ans;
    }
}

//BackTracking
public int combinationSum4(int[] nums, int target) {
        if (target<0) return 0;
        if (target==0) return 1;
        int ans = 0;
        for (int i=0; i<nums.length; i++){
            ans += combinationSum4(nums, target-nums[i]);
        }
        return ans;
    }
