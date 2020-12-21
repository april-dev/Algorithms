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



//bottom up
//initialize dp to 0 is wrong, consider[[0, 0, 0, 10, 0, 0, 0], [0, 0, 0, 10, 0, 0, 0]], answer should be 0, the middle ones wont be reached.
//Time: O(m * n^2)
//Space: O(m * n^2)
public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
        for (int i=1; i<m; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){
                    int cherries = j==k? grid[i][j]:(grid[i][j] + grid[i][k]);
                    for (int p=-1; p<=1; p++){
                        for (int q=-1; q<=1; q++){
                            int c1 = j+p;
                            int c2 = k+q;
                            if (c1>=0 && c1<n && c2>=0 && c2<n && dp[i-1][c1][c2] != -1) dp[i][j][k] = Math.max(dp[i][j][k], cherries+ dp[i-1][c1][c2]);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                res = Math.max(res, dp[m-1][i][j]);
            }
        }
        return res;
    }
