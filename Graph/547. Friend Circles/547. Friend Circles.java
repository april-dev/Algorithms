//Union find
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (M[i][j]==1) union(parent, i, j);
            }
        }
        int res = 0;
        for (int i=0; i<n; i++){
            if(parent[i]==i) res++;
        }
        return res;
    }
    public int find(int[] parent, int i){
        if (parent[i] != i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    public void union(int[] parent, int i, int j){
        int p1 = find(parent, i);
        int p2 = find(parent, j);
        if (p1!=p2) parent[p1] = p2;
    }
}




// dfs function is called N times. inside the dfs function, for loop runs 0...M.length (=N). 
//So, the dfs function viewed by itself is O(N) and the dfs function is called N times, so O(N*N).
public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i=0; i<M.length; i++){
            if (visited[i]==0){
                dfs(M, visited, i);
                count += 1;
            }
        }
        return count;
    }
     /*
     public void dfs(int[][] M, boolean[] visited, int i){
        if (visited[i]==true) return;
        visited[i] = true;
        for (int j=0; j<M.length; j++){
            if (M[i][j]==1) dfs(M, visited, j);
        }
    }
     */
     public void dfs(int[][] M, int[] visited, int i){
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j]=1;
                dfs(M, visited, j);
            }
        }
    }
