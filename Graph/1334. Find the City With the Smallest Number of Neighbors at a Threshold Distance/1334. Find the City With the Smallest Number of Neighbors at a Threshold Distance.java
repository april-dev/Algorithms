public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge: edges){
            map.putIfAbsent(edge[0], new HashMap<>());
            map.putIfAbsent(edge[1], new HashMap<>());
            map.get(edge[0]).put(edge[1], edge[2]);
            map.get(edge[1]).put(edge[0], edge[2]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i=0; i<n; i++){
            dist[i] = dijkstra(map, i, n, distanceThreshold);
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        
        for (int i=0; i<n; i++){
            if (dist[i]<=min){
                min = Math.min(min, dist[i]);
                res = i;
            }
        }
        return res;
    }
    public int dijkstra(Map<Integer, Map<Integer, Integer>> map, int i, int n, int threshold){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        boolean[] seen = new boolean[n];
        pq.add(new int[]{threshold, i});
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int tleft = cur[0];
            int node = cur[1];
            if (seen[node]) continue;
            seen[node] = true;
            if (map.containsKey(node)){
                for (int child:map.get(node).keySet()){
                    int tleft2 = tleft-map.get(node).get(child);
                    if (tleft2>=0) pq.add(new int[]{tleft2, child});
                }
            }
        }
        int sum = 0;
        for (int m=0; m<n; m++) if (seen[m]==true) sum++;
        return sum;
    }
    
    
    //another Dijkstra
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9 + 7;
        List<int[]>[] adj = new List[n];
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {adj[i] = new ArrayList<>();}
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int d = e[2];
            
            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
            // dist[u][v] = d;
            // dist[v][u] = d;
        }
        
        // floyd(n, adj, dist);
        for (int i = 0; i < n; i++) {
            dijkstra(n, adj, dist[i], i);
        }
        
        int minCity = -1;
        int minCount = n;
        
        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {continue;}
                if (dist[i][j] <= distanceThreshold) {curCount++;}
            }
            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }
        
        return minCity;
    }

    
    void dijkstra(int n, List<int[]>[] adj, int[] dist, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0];
            int du = cur[1];
            //if (du > dist[u]) {continue;}
            
            for (int[] nb : adj[u]) {
                int v = nb[0];
                int duv = nb[1];
                if (dist[v] > du + duv) {
                    dist[v] = du + duv;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
    }
    
    
    //Floyd Algorithm
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int res = 0, smallest = n;
        for (int[] row : dis)
            Arrays.fill(row, 10001);
        for (int[] e : edges)
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
        for (int i = 0; i < n; ++i)
            dis[i][i] = 0;
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j)
                if (dis[i][j] <= distanceThreshold)
                    ++count;
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }
    
    
