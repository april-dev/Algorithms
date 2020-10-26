public double champagneTower(int poured, int query_row, int query_glass) {
       double[]  dp = new double[query_row+1];
       dp[0] = poured;
       for (int row = 1; row<=query_row; row++){
           for (int i= row-1; i>=0; i--){
               dp[i] = Math.max(0, (dp[i]-1)/2);
               dp[i+1] += dp[i];
           }
       }
        return Math.min(1, dp[query_glass]);
    }
    
    //Space: O(N^2)
    public double champagneTower(int poured, int query_row, int query_glass) {
       double[][]  dp = new double[query_row+1][query_row+1];
       dp[0][0] = poured;
       for (int row = 0; row<query_row; row++){
           for (int i= 0; i<=row; i++){
               dp[row+1][i] += Math.max(0, (dp[row][i]-1)*1.0/2);
                dp[row+1][i+1] += Math.max(0, (dp[row][i]-1)*1.0/2);
           }
       }
        return Math.min(1, dp[query_row][query_glass]);
    }
