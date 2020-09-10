//DP O(N^2)
public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        int res=1;
        for (int i=1; i<nums.length;i++){
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

//Binary Search O(NlogN)
public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}


 //recursive
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i=0; i<nums.length; i++){
            ans = Math.max( ans, helper(nums, i, dp));
        }
        return ans;
    }
    
    public int helper(int[] nums, int i, int[] dp){
        if (i==0) return 1;
        if (dp[i]>0) return dp[i];
        int ans = 1;
        for (int j=0; j<i; j++){
            if (nums[j]<nums[i]) ans = Math.max(ans, helper(nums, j, dp)+1);
        }
        dp[i] = ans;
        return ans;
    }
