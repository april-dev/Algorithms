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
