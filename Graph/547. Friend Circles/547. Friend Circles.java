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
    
     public void dfs(int[][] M, int[] visited, int i){
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j]=1;
                dfs(M, visited, j);
            }
        }
    }
