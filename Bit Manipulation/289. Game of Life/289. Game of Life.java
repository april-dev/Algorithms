class Solution {
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0) return;
        int m = board.length, n = board[0].length;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int lives = countLives(board, m, n, i, j);
                
                if (board[i][j] == 1 && lives<=3 && lives>=2){
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;
                }                
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                board[i][j] = (board[i][j]>>1);
            }
        }
    }
    public int countLives(int[][] board, int m, int n, int i, int j){
        int count = 0;
        for (int x = Math.max(0, i-1); x <= Math.min(i+1, m-1); x++){
            for (int y = Math.max(0, j-1); y <= Math.min(j+1, n-1); y++){
                count += (board[x][y] & 1);
            }
        }
        count -= (board[i][j] & 1);
        return count;
    }
}
