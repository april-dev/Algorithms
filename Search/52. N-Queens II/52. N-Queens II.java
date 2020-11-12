class Solution {
    int res = 0;
    public int totalNQueens(int n) {     
        char[][] chess= new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                chess[i][j] = '.';
            }
        }
        dfs(chess, 0);
        return res;
    }
    public void dfs(char[][] chess, int row){
        if (row==chess.length){
            res++;
            return;
        }
        for (int i=0; i<chess.length; i++){
            if (valid(chess, row, i)){
                chess[row][i] = 'Q';
                dfs(chess, row+1);
                chess[row][i] = '.';
            }
        }
    }
    public boolean valid(char[][] chess, int row, int col){
        for (int i=0; i<chess.length; i++){
            if (chess[i][col]=='Q') return false;
        }
        for (int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++ ){
            if (chess[i][j]=='Q') return false;
        }
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j-- ){
            if (chess[i][j]=='Q') return false;
        }
        return true;
    }
}
