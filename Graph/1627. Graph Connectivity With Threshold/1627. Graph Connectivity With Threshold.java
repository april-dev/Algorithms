class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UF uf = new UF(n);
        for (int i=1; i<=n; i++){
            for (int j=2*i; j<=n; j+=i){
                if (i>threshold) uf.union(i, j);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query: queries){
            int p1 = uf.find(query[0]);
            int p2 = uf.find(query[1]);
            if (p1!=p2) res.add(false);
            else res.add(true);
        }
        return res;
    }
    class UF{
        int[] parent, size;
        public UF(int n){
            parent = new int[n+1];
            for (int i=1; i<=n; i++){
                parent[i] = i;
            }
        }
        public int find(int i){
            if (parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public void union(int a, int b){
            int p1 = find(a);
            int p2 = find(b);
            if (p1 != p2) parent[p1] = p2;
        }
    }
}
