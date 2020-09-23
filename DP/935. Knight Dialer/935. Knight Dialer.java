class Solution {
    int[][] dirs = {{-1, -2},{-2, -1}, {-2, 1}, {-1, 2}, {1, 2},{2, 1},{2, -1},{1, -2}};
    int mod = 1000000000+7;
    
    public int knightDialer(int n) {
        int res = 0;    
        int[][][] dp = new int[4][3][n+1];
            
        for (int i=0; i<4; i++){     
            for (int j=0; j<3; j++)
            res = (res + helper(n, dp, i, j))%mod;
        }
        return res;
    }
    public int helper(int n, int[][][] dp, int i, int j){
        if (i<0 || i>=4 || j<0 || j>=3 || (i==3 && j!=1)) return 0;
        if (dp[i][j][n]>0) return dp[i][j][n];
        if (n==1) return 1;
        int ans = 0;     
        for (int[] dir:dirs){
             int x = i+dir[0];
             int y = j+dir[1];
             ans = (ans+helper(n-1, dp, x, y))%mod;                       
         }
        dp[i][j][n] = ans;
        return ans;
    }
}

public int knightDialer(int N) {
        final int MODULUS = 1_000_000_007;
        if(N == 1) return 10;
        int[][] jumpMap = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int[] dp = new int[10];
        Arrays.fill(dp,1);
        for(int n = N;n > 1;n--){
            int[] temp = new int[10];
            for(int i = 0;i< jumpMap.length;i++){
                for(int j = 0;j< jumpMap[i].length;j++){
                    int position = jumpMap[i][j];// jump from number i, to position
                    temp[position] = (temp[position] + dp[i] % MODULUS) % MODULUS;
                }
            }
            dp = temp;
        }
        int ans = 0;
        for(int num : dp) ans = (ans + num % MODULUS) % MODULUS;
        return ans;
    }
