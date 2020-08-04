//Greedy. Not exactly the best time to buy and sell stock, only maximize profit.
public int maxProfit(int[] prices) {
        int acc = 0;       
        for (int i=1; i<prices.length; i++){
            if (prices[i]-prices[i-1]>0){
                acc += prices[i]-prices[i-1];               
            }
        }
        return acc;
    }
    
 //can record the buying and selling days.
 public int maxProfit(int[] prices) {
        int i=0, buy, sell, profit = 0, N = prices.length-1;
        while (i<N){
            while (i<N && prices[i+1]<=prices[i]) i++;
            buy = prices[i];
            while (i<N && prices[i+1]>=prices[i]) i++;
            sell = prices[i];
            profit+=(sell-buy);
        }
        return profit;
    }
