//BFS
public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<routes.length; i++){
            for (int j=0; j<routes[i].length; j++){
                map.putIfAbsent(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        
        queue.add(S);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int cur = queue.poll();
                for (int bus:map.get(cur)){
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int route: routes[bus]){
                        if (route==T) return level;
                        queue.add(route);
                    }
                }
            }
            level++;
        }
        return -1;
    }
