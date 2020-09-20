public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
       int mod = 1000000007;
        max[0][0] = min[0][0] = grid[0][0];
        for (int i=1; i<m; i++){
            max[i][0] = min[i][0] = min[i-1][0]*grid[i][0];
        }
        for (int j=1; j<n; j++){
            max[0][j] = min[0][j] = min[0][j-1]*grid[0][j];
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                long mincan = grid[i][j]* Math.min(min[i-1][j], min[i][j-1]);
                long maxcan = grid[i][j]*Math.max(max[i-1][j], max[i][j-1]);
                min[i][j] = Math.min(mincan, maxcan);
                max[i][j] = Math.max(mincan, maxcan);
            }
        }
        return max[m-1][n-1]<0?-1:(int)(max[m-1][n-1]%mod);
    }
    
    //Another version
    public int maxProductPath(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    long[][] mn = new long[n][m], mx = new long[n][m];
    mn[0][0] = mx[0][0] = grid[0][0];
    
    for(int i=1; i<n; i++){
        mn[i][0] = mx[i][0] = mx[i-1][0] * grid[i][0];
    }
    for(int j=1; j<m; j++){
        mn[0][j] = mx[0][j] = mx[0][j-1] * grid[0][j];
    }

    for(int i = 1; i < n; ++i) {
        for(int j = 1; j < m; ++j) {
            int curr = grid[i][j];
            long min = Math.min(mn[i-1][j], mn[i][j-1]);
            long max = Math.max(mx[i-1][j], mx[i][j-1]);
            if(curr >= 0) {
                mx[i][j] = max * curr;
                mn[i][j] = min * curr;
            } else {
                mx[i][j] = min * curr;
                mn[i][j] = max * curr;
            }
        }
    }
    long res = mx[n-1][m-1];
    long mod = (long)1e9 + 7;
    return res < 0 ? -1 : (int)(res % mod);
}
