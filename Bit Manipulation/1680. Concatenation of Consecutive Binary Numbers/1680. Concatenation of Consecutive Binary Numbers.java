public int concatenatedBinary(int n) {
        long res = 0;
        int mod = (int) 1e9+7;
        
        for (int i=1; i<=n; i++){         
            int count = 0;
            long temp = i; 
            while(temp>0){
                count++;
                temp = (temp>>1);
            }
            res = ((res<<count) % mod + i) % mod;
        }
        return (int) res;
    }
