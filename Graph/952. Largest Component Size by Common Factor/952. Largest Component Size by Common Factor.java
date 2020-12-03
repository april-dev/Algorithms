//Time: O(N^2)
//TLE
class Solution {
    public int largestComponentSize(int[] A) {
        int[] parent = new int[A.length];
        for (int i=0; i<A.length; i++) parent[i] = i;
        for (int i=0; i<A.length; i++){
            for (int j=i+1; j<A.length; j++){
                if (factor(A[i], A[j])){
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if (p1!=p2) parent[p1] = p2;
                }
            }
        }
        int res = 0;
        int[] count = new int[A.length];
        for (int i=0; i<parent.length; i++){
            int p = find(parent, i);
            count[p]++;
        }
        for (int i=0; i<A.length; i++) res = Math.max(res, count[i]);
        return res;
    }
    public int find(int[] parent, int i){
        if (parent[i]!=i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    public boolean factor(int a, int b){
        for (int i=2; i<=Math.min(a, b); i++){
            if (a%i==0 && b%i==0) return true;
        }
        return false;
    }
}

//HashMap
class Solution {
    class UF {
        int[] parent;
        int[] size;
        int max;
        public UF (int N){
            parent = new int[N];
            size = new int[N];
            max = 1;
            for (int i = 0; i < N; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            if (x == parent[x]){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                max = Math.max(max, size[rootY]);
            }
        }
    }
    public int largestComponentSize(int[] A) {
        int N = A.length;
        Map<Integer, Integer> map = new HashMap<>();// key is the factor, val is the node index
        UF uf = new UF(N);
        for (int i = 0; i < N; i++){
            int a = A[i];
            for (int j = 2; j * j <= a; j++){
                if (a % j == 0){
                    if (!map.containsKey(j)){//this means that no index has claimed the factor yet
                        map.put(j, i);
                    }else{//this means that one index already claimed, so union that one with current
                        uf.union(i, map.get(j));
                    }
                    if (!map.containsKey(a/j)){
                        map.put(a/j, i);
                    }else{
                        uf.union(i, map.get(a/j));
                    }
                }
            }
            if (!map.containsKey(a)){//a could be factor too. Don't miss this
                map.put(a, i);
            }else{
                uf.union(i, map.get(a));
            }
        }
        return uf.max;
    }
}

//My solution using HashMap
class Solution {
    int max = 0;
    public int largestComponentSize(int[] A) {
        int[] parent = new int[A.length];
        int[] count = new int[A.length];
        for (int i=0; i<A.length; i++) {
            parent[i] = i;
            count[i] = 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.length; i++){
            int a = A[i];
            for (int j=2; j*j<=a; j++){
                if (a%j == 0){
                    if (!map.containsKey(j)) map.put(j, i);
                    else union(parent, count, i, map.get(j));
                    
                    if (!map.containsKey(a/j)) map.put(a/j, i);
                    else union(parent, count, i, map.get(a/j));
                }         
            }
            if (!map.containsKey(a)) map.put(a, i);
            else union(parent, count, i, map.get(a));
        }
        
        int res = 0;
        for (int i=0; i<parent.length; i++){
            if (parent[i]==i) res = Math.max(res, count[i]);
        }
        
        return res;
    }
    public int find(int[] parent, int i){
        if (parent[i]!=i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    public void union(int[] parent, int[] count, int i, int j){
        int p1 = find(parent, i);
        int p2 = find(parent, j);
        if (p1!=p2){
            parent[p1] = p2;
            count[p2] += count[p1];
            //max = Math.max(max, count[p2]);
        }
    }
}




//Prime Factorization and Union Find
class Solution {
    int max = 0;
    public int largestComponentSize(int[] A) {
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        Set<Integer> primes = new HashSet<>();
        // all primes less than 100000
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2; j * i <= 100000; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        int n = A.length;
        int[] counts = new int[n];
        int[] parents = new int[n];
        int[] primeToIndex = new int[100001];
        Arrays.fill(primeToIndex, -1);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            counts[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int a = A[i];
            for (int p : primes) {
                if (primes.contains(a)) { // Optimization
                    p = a;
                }
                if (a % p == 0) {
                    if (primeToIndex[p] > -1) {
                        union(parents, counts, primeToIndex[p], i);
                    }
                    primeToIndex[p] = i;
                    while (a % p == 0) {
                        a /= p;
                    }
                }
                if (a == 1) {
                    break;
                }
            }
        }
        return max;
    }
    private int find(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = find(parents, parents[a]);
        }
        return parents[a];
    }
    private void union(int[] parents, int[] counts, int a, int b) {
        int root1 = find(parents, a), root2 = find(parents, b);
        if (root1 == root2) {
            return;
        }
        int count = counts[root2] + counts[root1];
        max = Math.max(count, max);
        parents[root1] = root2;
        counts[root2] = count;
    }
}
