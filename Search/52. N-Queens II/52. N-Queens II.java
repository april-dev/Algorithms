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



//faster version
class Solution {
    int res = 0;
    public int totalNQueens(int n) {     
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2*n - 1];
        boolean[] d2 = new boolean[2*n - 1];
        dfs(n, 0, cols, d1, d2);
        return res;
    }
    public void dfs(int n, int row,boolean[] cols, boolean[] d1, boolean[] d2){
        if (row == n){
            res++;
            return;
        }
        for (int col=0; col<n; col++){
            int index_d1 = col + row;
            int index_d2 = col - row + n - 1;
            
            if (!cols[col] && !d1[index_d1] && !d2[index_d2]){
                cols[col] = true; d1[index_d1] = true; d2[index_d2] = true;                
                dfs(n, row+1, cols, d1, d2);
                cols[col] = false; d1[index_d1] = false; d2[index_d2] = false;
            }
        }
    }
}
