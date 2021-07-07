public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        buy[1] = -prices[0];
        for (int i=2; i<=n; i++){
            buy[i] = Math.max(sell[i-2]-prices[i-1], buy[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i-1]);
        }
        return sell[n];
    }











public int maxProfit(int[] prices) {
       int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
    
    for (int price : prices) {
        int T_ik0_old = T_ik0;
        T_ik0 = Math.max(T_ik0, T_ik1 + price);
        T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
        T_ik0_pre = T_ik0_old;
    }
    
    return T_ik0;
    }
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
    buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   
    sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
    
    */
    public int maxProfit(int[] prices) {
      int prevbuy = Integer.MIN_VALUE, buy = Integer.MIN_VALUE, sell = 0, prevsell=0;
        for (int price:prices){
            prevbuy = buy;
            buy = Math.max(prevbuy, prevsell-price);
            prevsell = sell;
            sell = Math.max(prevsell, prevbuy+price);
        }
        return sell;
    }
