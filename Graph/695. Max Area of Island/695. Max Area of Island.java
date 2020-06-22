//solution from discuss
class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int m=grid.length,n=grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    //max=Math.max(max,dfs(grid,i,j));
                    max=Math.max(max,bfs(grid,i,j));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int i, int j){
        int m=grid.length,n=grid[0].length;
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0) return 0;
        grid[i][j]=0;
        int res=1;
        for (int[] dir:dirs){
            int i1=dir[0]+i;
            int j1=dir[1]+j;
            res+=dfs(grid,i1,j1);
        }
        return res;
    }
    private int bfs(int[][] grid, int i, int j){
        int m=grid.length,n=grid[0].length;
        if(grid[i][j]==0) return 0;
        grid[i][j]=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        int res=1;
        while(!q.isEmpty()){
            int[] pos=q.poll();
            for (int[] dir:dirs){
                int x=dir[0]+pos[0];
                int y=dir[1]+pos[1];
                if(x<0||x>=m||y<0||y>=n||grid[x][y]==0){
                    continue;
                }
                grid[x][y]=0;
                res++;
                q.offer(new int[]{x,y});
            }
        }
        return res;
    }
}

//my solution
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        
        int maxArea = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1) maxArea = Math.max(maxArea, dfs(grid, i, j));                
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;        
        return  1+ dfs(grid, i-1, j) + dfs(grid, i+1, j)+dfs(grid, i, j-1)+dfs(grid, i, j+1);       
    }
}
