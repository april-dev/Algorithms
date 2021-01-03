//my solution
public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int mod = 1000000007;
        for (int d: deliciousness){
            if (map.containsKey(d)) {
                count += map.get(d);
                count %= mod;
            }
            for (int j=0; j<=21; j++){
                map.put((1<<j) - d, map.getOrDefault((1<<j) - d, 0) + 1);
            }
        }
        return count;
    }


public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int mod = 1000000007;
        for (int d: deliciousness){            
            for (int j=0; j<=21; j++){
                if (map.containsKey((1<<j) - d)){
                    count += map.get((1<<j) - d);
                    count %= mod;
                }
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return count;
    }
