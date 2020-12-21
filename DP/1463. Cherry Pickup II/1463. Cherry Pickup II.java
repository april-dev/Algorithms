class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return dfs(grid, 0, 0, n-1, dp);
    }
    public int dfs(int[][] grid, int r, int c1, int c2, Integer[][][] dp){
        if (r == grid.length) return 0;
        if (dp[r][c1][c2] != null) return dp[r][c1][c2];
        
        int ans = 0;
        for (int i=-1; i<=1; i++){
            for (int j=-1; j<=1; j++){
                int nc1 = c1 + i, nc2 = c2 + j;
                if (nc1>=0 && nc1<grid[0].length && nc2>=0 && nc2<grid[0].length){
                    ans = Math.max(ans, dfs(grid, r+1, nc1, nc2, dp));
                }
            }
        }
        int cherries = c1==c2? grid[r][c1]: (grid[r][c1] + grid[r][c2]);
        dp[r][c1][c2] = ans + cherries;
        return dp[r][c1][c2];
    }
}
