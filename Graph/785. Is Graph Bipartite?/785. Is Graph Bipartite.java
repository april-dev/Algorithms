//My solution
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] states = new int[graph.length];
        boolean temp;
        for (int i=0; i<graph.length; i++){           
            if (states[i]==0) temp = dfs(graph, i, states, 1);
         //redundant line because after it enters the dfs function below, it will immediately return true for the second if condition.
            else temp = dfs(graph, i, states, states[i]);
            if (temp==false) return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph, int i, int[] states, int state){
        if (states[i]!=0 && states[i]!=state) return false;
        if (states[i]!=0 && states[i]==state) return true;
        states[i] = state;
        for (int j=0; j<graph[i].length; j++){
            if (dfs(graph, graph[i][j], states, state*(-1))==false) return false;
        }
        return true;
    }
}



//solution from Leetcode
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
