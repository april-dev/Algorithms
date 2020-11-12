//The time complexity should be 9 ^ m, m represents the number of blanks to be filled in
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    public boolean helper(char[][] board, int x, int y){
    //reset y to 0;
        for (int i=x; i<9; i++, y=0){
            for (int j=y; j<9; j++){
                if (board[i][j] != '.') continue;
                for (char c = '1'; c<='9'; c++){
                    if (isValid(board, i, j, c)==true){
                        board[i][j] = c;
                        if(helper(board, i, j+1)==true) return true;
                        board[i][j] = '.';                           
                    }                        
                }
                return false;                                     
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char c){
        int rowRegion = row/3*3;
        int colRegion = col/3*3;
        for (int i=0; i<9; i++){
            if(board[row][i]==c) return false;
            if (board[i][col]==c) return false;
        }
        for (int i=rowRegion; i<rowRegion+3; i++){
            for (int j=colRegion; j<colRegion+3; j++){
                if (board[i][j]==c) return false;
            }
        }
        return true;
    }    
}

//alternative isValid function
private boolean isValid(char[][] board, int row, int col, char c){
        int regionRow = 3 * (row / 3);  //region start row
        int regionCol = 3 * (col / 3);    //region start col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false; //check row
            if (board[row][i] == c) return false; //check column
            if (board[regionRow + i / 3][regionCol + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
    
    
    
//Alternative solution: start loop from beginning every time rather than start from next possible position
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
