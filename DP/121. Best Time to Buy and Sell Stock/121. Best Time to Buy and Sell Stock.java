//Use DP
//generalization Q188.Best Time to Buy and Sell Stock IV
public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==1) return 0;
        int tempMin = prices[0];
        int[] dp = new int[n];
        for (int i=1; i<n; i++){
            dp[i]= Math.max(dp[i-1], prices[i]-tempMin);
            tempMin = Math.min(tempMin, prices[i]);
        }
        return dp[n-1];
    }

//to further simplify, dont need an array, just need a variable
public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==1) return 0;
        int tempMin = prices[0];
        int result = 0;
        for (int i=1; i<n; i++){
            result= Math.max(result, prices[i]-tempMin);
            tempMin = Math.min(tempMin, prices[i]);
        }
        return result;
    }











//transform to Q53 max Subarray
//Only difference is Q53 can have negative result, but in this question , it is bounded below by 0.
class Solution {
   public int maxProfit(int[] prices) {
       int n = prices.length;
       if (n<2) return 0;
       int[] gains = new int[n-1];
       for (int i=1; i<n; i++){
           gains[i-1] = prices[i] - prices[i-1];
       }
        return Math.max(0, maxSubarray(gains));
    }
    
    public int maxSubarray(int[] gains){
        int curMax = gains[0];
        int maxSoFar = gains[0];
        for (int i=1; i<gains.length; i++){
            curMax = Math.max(gains[i], curMax+gains[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }
}

//Same as Q53
 public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int cumProfit = 0;
        for (int i=1; i<prices.length; i++){
            cumProfit = Math.max(prices[i] - prices[i-1], prices[i] - prices[i-1]+cumProfit);
            maxProfit = Math.max(maxProfit, cumProfit);
            
        }
        return maxProfit;
    }



//Another DP
public int maxProfit(int[] prices) {
       if (prices.length<2) return 0;
       int minPrice = prices[0];
       int profit = 0;
       for (int i=1; i<prices.length; i++){
           profit = Math.max(profit, prices[i]- minPrice);
           minPrice = Math.min(minPrice, prices[i]);
       }
       return profit;
    }



public int maxProfit(int[] prices) {
       int t0=0, t1 = Integer.MIN_VALUE;
        
        for (int price:prices){
            t0 = Math.max(t0, t1+price);
            t1 = Math.max(t1, -price);
        }
        return Math.max(t0, t1);
    }
