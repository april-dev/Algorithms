 public int maxProfit(int[] prices) {
       int t0=0, t1 = Integer.MIN_VALUE;
        
        for (int price:prices){
            t0 = Math.max(t0, t1+price);
            t1 = Math.max(t1, -price);
        }
        return Math.max(t0, t1);
    }
