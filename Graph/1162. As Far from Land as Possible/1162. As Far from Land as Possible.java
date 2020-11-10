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
class Solution {   
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    helper(grid, i, j, 1);
                }
            }
        }
        int res = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                res = Math.max(res, grid[i][j]);
            }
        }
        return res==1?-1:res-1;
        
    }
    public void helper(int[][] grid, int x, int y, int level){
        if (x<0 || x>=grid.length || y<0 || y>=grid.length || grid[x][y]!=0 && grid[x][y]<=level) return;
        grid[x][y] = level;
        helper(grid, x+1, y, level+1);
        helper(grid, x-1, y, level+1);
        helper(grid, x, y+1, level+1);
        helper(grid, x, y-1, level+1);
    }
}
