Map<Integer, Integer> cntMap = new HashMap<>();
    Map<Integer, Set<Integer>> squareMap = new HashMap<>();
    int cnt = 0;
    public int numSquarefulPerms(int[] A) {
        for (int num : A) {
            if (!cntMap.containsKey(num)) {
                cntMap.put(num, 1);
                squareMap.put(num, new HashSet<>());
            } else {
                cntMap.put(num, cntMap.get(num) + 1);
            }
        }
        for (int num1 : cntMap.keySet()) {
            for (int num2 : cntMap.keySet()) {
                double c = Math.sqrt(num1 + num2);
                if (c == Math.floor(c)) {
                    squareMap.get(num1).add(num2);
                    squareMap.get(num2).add(num1);
                }
            }
        }
        for (int num: cntMap.keySet()) {
            countPerm(num, A.length - 1);
        }
        return cnt;
    }
    
    private void countPerm(int num, int left) {
        cntMap.put(num, cntMap.get(num) - 1);
        if (left == 0) { cnt++; }
        else {
            for (int next : squareMap.get(num)) {
                if (cntMap.get(next) != 0) {
                    countPerm(next, left - 1);
                }
            }
        }
        cntMap.put(num, cntMap.get(num) + 1);
    }



//without global variable
public int numSquarefulPerms(int[] A) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int a:A){
            if (!cnt.containsKey(a)){
                cnt.put(a, 1);
                map.put(a, new HashSet<>());
            }else{
                cnt.put(a, cnt.get(a)+1);
            }
        }
        for (int i:cnt.keySet()){
            for (int j:cnt.keySet()){
                double c = Math.sqrt(i+j);
                if (c==Math.floor(c)){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        int res = 0;
        for (int i:cnt.keySet()){
            res += dfs(cnt, map, A.length-1, i);  
        }
        return res;
                
    }
    public int dfs(Map<Integer, Integer> cnt, Map<Integer, Set<Integer>> map, int left, int node){
        int c = 0;
        if (left==0) return 1;
        cnt.put(node, cnt.get(node)-1);
        //int c = 0;
        for (int child:map.get(node)){
            if (cnt.get(child)!=0) c += dfs(cnt, map, left-1, child);
        }
        cnt.put(node, cnt.get(node)+1);
        return c;
    }
