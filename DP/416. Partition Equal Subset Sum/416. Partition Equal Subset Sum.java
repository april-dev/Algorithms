public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num:nums) sum+=num;
        if (sum%2!=0)return false;
        int target = sum/2;
        
        boolean[][] dp = new boolean[n+1][target+1];
        dp[0][0] = true;
        for (int i=1; i<=n; i++) dp[i][0] = true;
        for (int j=1; j<=target; j++) dp[0][j] = false;
        
        for (int i=1; i<=n; i++){
            for (int j=1; j<=target; j++){
                dp[i][j] = dp[i-1][j];
                if (j>=nums[i-1]) dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][target];
    }
    
  
  public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums) sum+=num;
        if (sum%2!=0)return false;
        int target = sum/2;
        
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        
        for (int num:nums){
            for (int i=target; i>=0; i--){
                if (i-num>=0) dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[target];
    }
    
    
  //Backtracking
  public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums) sum+=num;
        if (sum%2!=0) return false;
        int target = sum/2;
        return helper(nums, 0, target);
    } 
    public boolean helper(int[] nums, int idx, int target){
        if (target<0) return false;
        if (target==0) return true;
        for (int i=idx; i<nums.length; i++){
            if (helper(nums, i+1, target-nums[i])) return true;
        }
        return false;
    }
    
    //DFS + memorization
    class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return helper(nums, 0, target, memo);
    }
    
    private boolean helper(int[] nums, int pos, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (pos == nums.length || target < 0) {
            return false;
        }
        if (memo[pos][target] != null) {
            return memo[pos][target];
        }
        
        if (helper(nums, pos + 1, target, memo)
            || helper(nums, pos + 1, target - nums[pos], memo)) {
            memo[pos][target] = true;
            return true;
        }
        memo[pos][target] = false;
        return false;
    }
}
