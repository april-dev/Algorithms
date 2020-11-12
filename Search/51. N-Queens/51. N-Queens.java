class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess= new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                chess[i][j] = '.';
            }
        }
        dfs(chess, 0, res);
        return res;
    }
    public void dfs(char[][] chess, int row, List<List<String>> res){
        if (row==chess.length){
            res.add(construct(chess));
            return;
        }
        for (int i=0; i<chess.length; i++){
            if (valid(chess, row, i)){
                chess[row][i] = 'Q';
                dfs(chess, row+1, res);
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
    public List<String> construct(char[][] chess){
        List<String> res = new ArrayList<>();
        for (int i=0; i<chess.length; i++){
            res.add(new String(chess[i]));
        }
        return res;
    }
}
