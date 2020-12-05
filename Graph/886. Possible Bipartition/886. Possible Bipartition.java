//My solution
//use boolean array instead of hashmap can save some space
//Time: O(V + E)

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] states = new int[N+1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike: dislikes){
            int d1 = dislike[0];
            int d2 = dislike[1];
            map.putIfAbsent(d1, new ArrayList<>());
            map.putIfAbsent(d2, new ArrayList<>());
            map.get(d1).add(d2);
            map.get(d2).add(d1);
        }
        for (int i=1; i<=N; i++){
            if (states[i]==0){
                if (dfs(i, 1, states, map)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int state, int[] states, HashMap<Integer, List<Integer>> map){
        if (states[node]!=0) return states[node]==state;
        states[node] = state;
        if (map.containsKey(node)){
            for (int child: map.get(node)){
                if (dfs(child, -state, states, map)==false) return false;
            }
        }
        return true;
    }
}


//solution from Leetcode
public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean[][] g = new boolean[N][N];
        for (int[] d : dislikes) {
            g[d[0] - 1][d[1] - 1] = true;
            g[d[1] - 1][d[0] - 1] = true;
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++)
            if (colors[i] == 0 && !paint(i, 1, colors, g))
                return false;
        return true;
    }

    boolean paint(int u, int color, int[] colors, boolean[][] g) {
        if (colors[u] != 0)
            return colors[u] == color;
        colors[u] = color;
        for (int v = 0; v < colors.length; v++)
            if (g[u][v] && !paint(v, -color, colors, g))
                return false;
        return true;
    }
