 public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        
        for (int i=0;i<n;i++){
            if (colors[i]==0 && !isValid(graph, colors, 1, i)) return false;
        }
        return true;
    }
    
    public boolean isValid (int[][] graph, int[] colors, int color, int node){
        if (colors[node]!=0) {
            return colors[node]==color;
        }
        colors[node] = color;
        for (int neighbor:graph[node]){
            if (!isValid(graph, colors, -color, neighbor)) return false;
        }
        return true;
    }

//BFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
                
        for (int i=0; i<n; i++){
            if (colors[i]==0 && !bfs(graph, colors, i)) return false;
        }
        return true;
    }
     public boolean bfs(int[][] graph, int[] colors, int i){   
        Queue<Integer> q = new LinkedList<>();
         q.add(i);
        colors[i]=1;
        while (!q.isEmpty()){
            int cur = q.remove();
            int curColor = colors[cur];
            for (int child: graph[cur]){
                if (colors[child]!=0 && colors[child]!=curColor*-1) return false;
                if (colors[child]!=0 && colors[child]==curColor*-1) continue;
                colors[child] = curColor*-1;
                q.add(child);
            }
        }
        return true;
    }
