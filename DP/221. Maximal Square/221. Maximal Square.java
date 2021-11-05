public int maximalSquare(char[][] matrix) {
        if (matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res =0;
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }


//O(1) space
public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j]=='1' && i!=0 && j!=0){
                    int ans = Math.min(matrix[i-1][j]-'0', Math.min(matrix[i][j-1]-'0', matrix[i-1][j-1]-'0'))+1;
                    res = Math.max(res, ans);
                    matrix[i][j] = (char)(ans+'0');
                }else{
                    res = Math.max(res, matrix[i][j]-'0');
                }
            }
        }
        return res*res;
    }
