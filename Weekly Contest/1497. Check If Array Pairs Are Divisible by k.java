    public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        
        for (int i=0; i<arr.length; i++){
            //in case negative number, plus k
            int remainder = (arr[i]%k+k)%k;
            rem[remainder]+=1;
        }
        for (int i=1; i<=(k-1)/2; i++){
            if (rem[i]!=rem[k-i]) return false;
        }
        return rem[0]%2==0;
    }
    
    //Two Sum (Hash Table)
    public boolean canArrange(int[] arr, int k) {
        int numPairs = arr.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; ++i){
            int modded = ((arr[i] % k) + k) % k;
            //int complement = (k - modded) % k;
            int complement = k - modded;
            if(map.getOrDefault(complement, 0) > 0){
                map.put(complement, map.get(complement) - 1);
                --numPairs;
            } else map.put(modded, map.getOrDefault(modded, 0) + 1);
        }
        
        return numPairs == 0;
