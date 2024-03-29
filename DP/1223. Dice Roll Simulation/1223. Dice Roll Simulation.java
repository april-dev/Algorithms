/*
dp[i][j] := # of sequences of length i end with j
dp[i][j] := sum(dp[i-1]) – invalid

Time complexity: O(n*6)
Space complexity: O(n*6)

*/

public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n+1][7];
        for (int i=0; i<6; i++) dp[1][i] = 1;
        dp[1][6] = 6;
        dp[0][6] = 1; //this is for the case when i - rollMax[j] ==1, so that i - rollMax[j] - 1 == 0
        
        for (int i=2; i<=n; i++){
            int total = 0;
            for (int j=0; j<6; j++){
                dp[i][j] = dp[i-1][6];
                if (i - rollMax[j] > 0){
                    int reduction = dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j];
                    dp[i][j] =  ((dp[i][j] - reduction) % mod + mod) % mod;
                }
                 dp[i][6] = (dp[i][6] + dp[i][j] % mod) % mod;  
            }
        }
        return dp[n][6];
    }


/*
def: dp[i][j][k] := # of sequences ends with k consecutive j after i rolls
Init: dp[1][*][1] = 1

transition:
dp[i][j][1] = sum(dp[i-1][p][*]), p != j
dp[i][j][k + 1] = dp[i-1][j]][k]

Time complexity: O(n*6*6*15)
Space complexity: O(n*6*15) -> O(6*15)
*/

public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) 1e9 + 7;
        int[][][] dp = new int[n+1][6][16];
        
        // dp[i][j][k] := # of sequences ends with k consecutive j after i rolls
        for (int i=0; i<6; i++) dp[1][i][1] = 1;
        
        for (int i=2; i<=n; i++){
            for (int j=0; j<6; j++){
                for (int p=0; p<6; p++){
                    for (int k=1; k<=rollMax[p]; k++){
                        if (p!=j) dp[i][j][1] = (dp[i][j][1] + dp[i-1][p][k])%mod;
                        else if (k<rollMax[p]) dp[i][j][k+1] = (dp[i][j][k+1] + dp[i-1][p][k])%mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int j=0; j<6; j++){
            for (int k = 1; k <= rollMax[j]; k++){
                ans = (ans + dp[n][j][k])%mod;
            }
        }
        return ans;
        
    }
