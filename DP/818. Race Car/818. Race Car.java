//BFS
public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new int[]{0,1});
        set.add("0-1");
        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                int[] cur = q.remove();
                if (cur[0]==target) return res;
                
                int pos1 = cur[0] +cur[1];
                int speed1 = cur[1]*2;
                if (!set.contains(pos1 + "-" + speed1) && pos1<2*target){
                    set.add(pos1 + "-" + speed1);
                    q.add( new int[]{pos1, speed1});
                }
                
                int pos2 = cur[0];
                int speed2 = cur[1]<0?1:-1;
                if (!set.contains(pos2 + "-" + speed2) && pos2<2*target){
                    set.add(pos2 + "-" + speed2);
                    q.add( new int[]{pos2, speed2});
                }
            }
            res++;
        }
        return res;
    }
    
    //top down 
    int[] dp = new int[10001];
    public int racecar(int t) {
        if (dp[t] > 0) return dp[t];
        int n = (int)(Math.log(t) / Math.log(2)) + 1;
        if (1 << n == t + 1) {
            dp[t] = n;
        } else {
            dp[t] = racecar((1 << n) - 1 - t) + n + 1;
            for (int m = 0; m < n - 1; ++m) {
                dp[t] = Math.min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
            }
        }
        return dp[t];
    }
    
    //Bottom up
    public int racecar(int target) {
        int[] f = new int[target + 1];
        for (int i = 1; i <= target; i++){
            int bound = (Integer.highestOneBit(i) << 1) - 1;
            int n = Integer.bitCount(bound);
            if (i == bound){
                f[i] = n;
                continue;
            }
            // overspeed
            f[i] = f[bound - i] + n + 1; // Reverse once
            // underspeed
            bound >>= 1;
            for (int j = 0; j < n; j++){
                int gap = (1 << j) - 1;
                f[i] = Math.min(f[i], f[i - bound + gap] + n + j + 1); // Reverse twice
            }
        }
        return f[target];
    }
