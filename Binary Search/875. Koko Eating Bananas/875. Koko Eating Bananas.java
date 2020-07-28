//time complexity: O(NlogM)
//M is the max value among all piles (upper boundary in the binary search) and N is a number of piles.
//For every binary search we iterate over all N piles.


public int minEatingSpeed(int[] piles, int H) {
         int left = 1, right = 1000000000;
         while (left<right){
             int mid = left + (right-left)/2;
             int hour = 0;
             for (int p:piles){
                 hour += (p-1)/mid + 1;
             }
             
             if (hour>H){
                 left = mid + 1;
             }else{
                 right = mid;
             }
         }
        return left;
    }
    
        public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = getMaxPile(piles);
        
        // Binary search to find the smallest valid K.
        while (lo <= hi) {
            int K = lo + ((hi - lo) >> 1);
            if (canEatAll(piles, K, H)) {
                hi = K - 1;
            } else {
                lo = K + 1;
            }
        }
        
        return lo;
    }
    
    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0; // Hours take to eat all bananas at speed K.
        
        for (int pile : piles) {
            countHour += pile / K;
            if (pile % K != 0)
                countHour++;
        }
        return countHour <= H;
    }
    
    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }
