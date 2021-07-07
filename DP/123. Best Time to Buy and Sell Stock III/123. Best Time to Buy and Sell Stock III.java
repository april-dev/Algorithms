public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        
        for (int k=1; k<=2; k++){
            int tempMax = -prices[0];
            for (int j=1; j<n; j++){
                tempMax = Math.max(tempMax, dp[k-1][j-1] - prices[j]);
                dp[k][j] = Math.max(dp[k][j-1], prices[j] + tempMax);
                
            }
        }
        return dp[2][n-1];
    }









//see discussion
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
 public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
            int sell1 = 0;
            int sell2 = 0;
            
        for (int p:prices){
            buy1 = Math.min(buy1, p);
            sell1 = Math.max(sell1, p-buy1);
             buy2 = Math.min(buy2, p-sell1);
            sell2 = Math.max(sell2, p-buy2);
        }
        return sell2;
 }
 
 
 //see discussion
 //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int i:prices){                             
            sell2 = Math.max(sell2, buy2+i);     
            buy2    = Math.max(buy2,    sell1-i);  
            sell1 = Math.max(sell1, buy1+i);     
            buy1    = Math.max(buy1,    -i);         
        }
        return sell2; ///Since sell1 is initiated as 0, so sell2 will always higher than release1.
    }
