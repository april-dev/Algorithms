public int countVowelPermutation(int n) {
        long[] dp = new long[5], next = new long[5];
        int MOD = (int) (1e9 + 7);
        for (int i=0; i<5; i++){
            dp[i] = 1;
        }
        for (int i=2; i<=n; i++){      
            next[0] = dp[1]+ dp[2] +  dp[4];
            next[1] = (dp[0] + dp[2]) % MOD;
            next[2] = (dp[1] + dp[3]) % MOD;
            next[3] = dp[2];
            next[4] = (dp[2] + dp[3]) % MOD; 
            long[] temp = new long[5];
            dp = next;
            next = temp;
            
        }
        long res = 0;
        for (int i=0; i<5; i++) res=(res+dp[i])%MOD;
        return (int)res;
    }
