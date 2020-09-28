 /*
 This question eaquals to partition an array into 2 subsets whose difference is minimal
(1) S1 + S2  = S
(2) S1 - S2 = diff  

==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2 

dp[x] = 1 means the sum x is possible.

Refer to Q494. Target Sum

*/
 
 
 public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int max = 0;
        for (int stone:stones) sum+=stone;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int stone:stones){
            for (int i=sum/2; i>=stone; i--){
                dp[i]= dp[i] || dp[i-stone];
                if (dp[i]==true) max = Math.max(max, i);          
            }
        }
        return sum-2*max;
    }
