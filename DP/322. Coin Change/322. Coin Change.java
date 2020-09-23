//my version
public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=1; i<=amount; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i=1; i<=amount; i++){
            for (int coin:coins){
                if (i-coin>=0){
                    
                    if(dp[i-coin]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1: dp[amount];
    }
    
 //optimized
 public int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount + 1];
       Arrays.fill(dp, amount + 1); 
       dp[0] = 0; 
       for(int j = 0; j < coins.length; j++){
         for(int i = 0; i <= amount; i++){
           if(i - coins[j] >= 0) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); 
         } 
       } 
       return dp[amount] > amount ? -1 : dp[amount];
    }
    
 //Recursive
 class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return helper(coins, amount, dp);
        
    }
    public int  helper(int[] coins, int amount, int[] dp){
        if (amount<0) return -1;
        if (amount==0) return 0;
        if (dp[amount]!=Integer.MAX_VALUE) return dp[amount];
        int ans = -1;
        for (int coin:coins){    
            int c = helper(coins, amount-coin, dp);
            if (c!= -1) ans = ans<0? c+1:Math.min(ans, c+1);     
        }
        dp[amount] = ans;
        
        return ans;
    }
}
