int res = 0, empty = 1, sx, sy, ex, ey;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
            return;
        if (grid[x][y] == 2) {
            if (empty == 0) res++;
            return;
        }
        grid[x][y] = -2;
        empty--;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        grid[x][y] = 0;
        empty++;
    }
    
    //without global variable
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int  empty = 1, sx=0, sy=0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==0){
                    empty++;
                }else if(grid[i][j]==1){
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, empty);
        
    }
    public int dfs(int[][] grid, int i, int j, int empty){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] < 0) return 0;
        if (grid[i][j]==2) {
            if (empty==0) return 1;
            return 0;
        }
        grid[i][j] = -2;
        
        int cnt = dfs(grid, i+1, j, empty-1) + dfs(grid, i-1, j, empty-1) + dfs(grid, i, j+1, empty-1) + dfs(grid, i, j-1, empty-1);
        grid[i][j] = 0;
        return cnt;
    }
