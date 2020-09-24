 public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] =1;
        for (int coin:coins){
            for (int i=1;i<=amount; i++){
                if (i>=coin) dp[i] += (dp[i-coin]);
            }
        }
        return dp[amount];
    }

public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        return helper(amount, coins, dp, 0);
    }
    public int helper(int amount, int[] coins, Integer[][] dp, int idx){
        if (amount<0 || idx == coins.length) return 0;
        if (amount==0) return 1;
        if (dp[idx][amount]!=null) return dp[idx][amount];
        
        int sum1 = helper(amount, coins, dp, idx+1);
        int sum2 = helper(amount-coins[idx], coins, dp, idx);
    
        dp[idx][amount] = sum1+sum2;
        return dp[idx][amount];
    }
