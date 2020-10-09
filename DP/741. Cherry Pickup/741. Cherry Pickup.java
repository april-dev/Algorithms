public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] m = new int[n][n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                Arrays.fill(m[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, helper(grid, n-1, n-1, n-1, m));
    }
    public int helper(int[][] grid, int x1, int y1, int x2,  int[][][] m){
        int y2 = x1+y1-x2;
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return -1;
        if (grid[y1][x1] < 0 || grid[y2][x2] < 0) return -1;
        if (x1 == 0 && y1 == 0) return grid[y1][x1];
        if (m[y1][x1][x2]!=Integer.MIN_VALUE) return m[y1][x1][x2];

        int ans = Math.max(Math.max(helper(grid, x1-1, y1, x2-1,m), helper(grid, x1, y1-1, x2-1,m)),
                           Math.max(helper(grid, x1-1, y1, x2,m), helper(grid, x1, y1-1, x2,m)));
        if (ans>=0) {
            ans += grid[y1][x1];
            if (x1!=x2) ans += grid[y2][x2];
        }

        m[y1][x1][x2] = ans;
        return ans;
    }
    public boolean valid(int x, int y, int[][] grid){
        int N = grid.length;
        if (x<0 || x>=N || y<0 || y>=N || grid[x][y]==-1) return false;
        return true;
    }
