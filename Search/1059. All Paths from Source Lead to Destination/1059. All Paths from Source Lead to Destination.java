public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int[] edge:edges){
            int start = edge[0];
            int end = edge[1];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(end);
        }
        return helper(n, map, source, destination, visited);
    }
    public boolean helper(int n, HashMap<Integer, List<Integer>> map, int source, int destination, boolean[] visited){
        if (!map.containsKey(source)) return source==destination;
        visited[source]=true;
        if (map.containsKey(source)){
        for (int child:map.get(source)){
            if (visited[child]==true || helper(n, map, child, destination, visited)==false) return false;
        }
        visited[source]=false;
        }
        return true;
    }
