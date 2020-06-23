int[][] offset = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i=0; i<m; i++) for (int j=0; j<n; j++)
            if (grid[i][j]==1){
                q.add(new int[]{i,j});
                visited[i][j]=true;
            }
        if (q.size()==0 || q.size()== m*n) return -1;
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                int[] cur = q.remove();
                for (int[] dir:offset){
                    int x = cur[0]+ dir[0]; 
                    int y = cur[1]+ dir[1]; 
                    if (x<0 || x>=m || y<0 || y>=n || visited[x][y]==true) continue;
                    visited[x][y]=true;
                    q.add(new int[]{x,y});
                    
                }
            }
            level+=1;
        }
        return level-1;
    }
    
    //DFS time comsuming
    void dfs(vector<vector<int>>& g, int i, int j, int dist = 1) {
  if (i < 0 || j < 0 || i >= g.size() || j >= g[i].size() || (g[i][j] != 0 && g[i][j] <= dist)) return;
  g[i][j] = dist;
  dfs(g, i - 1, j, dist + 1), dfs(g, i + 1, j, dist + 1), dfs(g, i, j - 1, dist + 1), dfs(g, i, j + 1, dist + 1);
}
int maxDistance(vector<vector<int>>& g, int mx = -1) {
  for (auto i = 0; i < g.size(); ++i)
    for (auto j = 0; j < g[i].size(); ++j)
      if (g[i][j] == 1) {
          g[i][j] = 0;
          dfs(g, i, j);
      }
  for (auto i = 0; i < g.size(); ++i)
    for (auto j = 0; j < g[i].size(); ++j)
      if (g[i][j] > 1) mx = max(mx, g[i][j] - 1);
  return mx;
}
