/*
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    */
    public int numSquares(int n) {
        Queue<Integer> Q = new LinkedList<>();
        int count = 0;
        
        Q.offer(n);
        while (!Q.isEmpty()){
            int size = Q.size();
            count += 1;
            for (int i=0; i<size; i++){
                int cur = Q.remove();
                for (int j=1; j*j<=cur; j++){
                    int res = cur-j*j;
                    if (res==0) {
                        return count;
                    }else{
                        Q.add(res);
                    }
                }
            }
        }
        return count;
    }
