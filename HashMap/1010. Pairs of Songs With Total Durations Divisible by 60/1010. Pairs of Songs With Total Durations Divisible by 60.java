//Two sum variation
//find x such that (t + x) % 60 = 0, i.e. x % 60 = 60 - t % 60.
//corner case: if t = 60, x = 60
//solution is x % 60 = (60 - t % 60) % 60

public int numPairsDivisibleBy60(int[] time) {
        for (int i=0; i<time.length; i++){
            if (time[i]!=60) time[i] = time[i]%60;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t: time){
            int comp = (60 - t) % 60;
            if (!map.containsKey(comp)){
                map.put(t%60, map.getOrDefault(t%60, 0)+1);
            }else{
                count+=map.get(comp);
                map.put(t%60, map.getOrDefault(t%60, 0)+1);               
            }
        }
        return count;
    }
