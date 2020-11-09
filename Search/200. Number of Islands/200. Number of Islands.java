public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n==0) return 0;
        int m = grid[0].length;
        int count = 0;
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]=='1'){
                    count += 1;
                    dfsHelper(grid, i,j);
                }
            }
        }
        return count;
    }
    public void dfsHelper(char[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') return;
        grid[i][j]='0';
        dfsHelper(grid, i+1, j);
        dfsHelper(grid, i, j+1);
        dfsHelper(grid, i-1, j);
        dfsHelper(grid, i, j-1);        
    }
    
    //BFS
    public int numIslands(char[][] grid) {
        Queue<int[]> Q = new LinkedList<>();
        int n = grid.length;
        if (n==0) return 0;
        
        int m = grid[0].length;
        int count = 0;
        int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]=='1'){
                    grid[i][j] = '0';
                    count += 1;
                    
                    Q.offer(new int[]{i,j});
                    while (!Q.isEmpty()){
                        int[] cur = Q.remove();
                        for (int[] dir:offset){
                            int x = cur[0]+dir[0];
                            int y = cur[1]+dir[1];
                            if (x>=0 && x<n && y>=0 && y<m && grid[x][y]=='1'){
                               grid[x][y] = '0';
                               Q.offer(new int[]{x,y});
                            }
                        }
                    }
                 }
            }
        }
        return count;
    }
