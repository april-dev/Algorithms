//O(N^2*k) solution
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n==0) return 0;
        int[][] dp = new int[k+1][n];
        for (int i=1; i<=k; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = dp[i][j-1];
                int profit = 0;
                for (int t=0; t<j; t++){                    
                    profit = Math.max(profit, prices[j]-prices[t] + ((t-1)<0?0:dp[i-1][t-1]));
                }
                dp[i][j] = Math.max(dp[i][j], profit);
            }
        }
        return dp[k][n-1];          
    }
}










/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
//Note that in equation above, we can also write 
// = max(dp[i, j-1], prices[j] - min (prices[jj] + dp[i-1, jj]) )
//the commented section below is using min, which is the method used in Q123.

public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        
        if (k >=  n/2) {
		int maxPro = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i-1])
				maxPro += prices[i] - prices[i-1];
		}
		return maxPro;
	}
        int[][] dp=new int[k+1][n];
        /*
        for (int j=1;j<=k;j++){
            int min=prices[0];
            for (int i=1;i<n;i++){
                min=Math.min(min, prices[i]-dp[j-1][i-1]);
                dp[j][i] = Math.max(dp[j][i-1], prices[i] - min);
                
            }
        }
        return dp[k][n-1];
        */
        for (int i = 1; i <= k; i++) {
    	int localMax = - prices[0];
    	for (int j = 1; j < n; j++) {
            localMax = Math.max(localMax, dp[i-1][j-1] - prices[j]);
    		dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
    		
    	}
    }
    return dp[k][n-1];
    }
