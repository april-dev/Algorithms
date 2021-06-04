public int getKth(int lo, int hi, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = hi-lo+1;
        int[][] res = new int[hi-lo+1][2];
        int inc = lo;
        for (int i=0; i<n; i++){
            res[i][0] = inc;            
            res[i][1] = helper(inc, map);
            inc++;
        }
        Arrays.sort(res,(a,b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        return res[k-1][0];
        
    }
    public int helper(int n, Map<Integer, Integer> map){
        if (n==1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = 0;
        if (n%2==0) res= helper(n/2, map)+1;
        else res=helper(3*n+1, map)+1;
        map.put(n, res);
        return res;
    }
