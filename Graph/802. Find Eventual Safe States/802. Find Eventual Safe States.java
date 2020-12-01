public List<Integer> eventualSafeNodes(int[][] graph) {
            int[] visited = new int[graph.length];
            List<Integer> res = new ArrayList<>();
            for (int i=0; i<graph.length; i++){
                if (dfs(graph, i, visited)) res.add(i);
                }
            return res;
        }
        public boolean dfs(int[][] graph, int i, int[]visited){
            if (visited[i]==1) return false;
            if (visited[i]==2) return true;
            
            visited[i]=1;
            for (int child:graph[i]){
                if (!dfs(graph, child, visited)) return false;
            }
            visited[i]=2;
            return true;
        }
        
//topological sort
//Using degree array to record the out-degree, neighbors map to record In-neighbors(for example 0->1, 2->1, map(1) = [0, 2]).
        public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] degree = new int[N];
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                if (!neighbors.containsKey(neighbor)) neighbors.put(neighbor, new HashSet<Integer>());
                neighbors.get(neighbor).add(i);
                degree[i]++;
            }
        }
        
        Set<Integer> res = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                res.add(i);
                queue.add(i);
            }    
        }
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);
            if (neighbors.containsKey(v)) {
                for (int neighbor : neighbors.get(v)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            
        }
        List<Integer> list = new ArrayList<Integer>(res);
        Collections.sort(list);
        return list;
    }
