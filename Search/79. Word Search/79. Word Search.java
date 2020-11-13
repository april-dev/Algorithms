/*
The binary value for 256 is 100000000. Now we have ascii chars upto 255 numbers so their binary value is between - [00000000 - 11111111] (0 - 255).
Now if you do XOR(^) operation between these ascii chars and 256 it will convert all the range above 256 number. Java has 16 bits for char type. 
So this is possible. And now none of out string chars will match any of these masked chars because one is under 0-255 other is above 256 range.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (dfs(board, arr, 0, i, j)) return true;
            }
        }
        return false; 
    }
    public boolean dfs(char[][] board, char[] arr, int idx, int x, int y){
        if (idx==arr.length) return true;
        if (x<0 || x>=board.length || y<0 || y>=board[0].length) return false;
        if (board[x][y]!=arr[idx]) return false;
        board[x][y] ^= 256;
        boolean exist =  dfs(board, arr, idx+1, x+1, y) ||
            dfs(board, arr, idx+1, x-1, y) ||
            dfs(board, arr, idx+1, x, y+1) ||
            dfs(board, arr, idx+1, x, y-1);
        board[x][y] ^= 256;
        return exist;
    }
}

//alternative
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (dfs(board, arr, 0, i, j)) return true;
            }
        }
        return false; 
    }
    public boolean dfs(char[][] board, char[] arr, int idx, int x, int y){
        if (idx==arr.length) return true;
        if (x<0 || x>=board.length || y<0 || y>=board[0].length) return false;
        if (board[x][y]!=arr[idx]) return false;
        board[x][y] ^= 256;
        boolean exist =  dfs(board, arr, idx+1, x+1, y) ||
            dfs(board, arr, idx+1, x-1, y) ||
            dfs(board, arr, idx+1, x, y+1) ||
            dfs(board, arr, idx+1, x, y-1);
        if (exist==true) return true;
        board[x][y] ^= 256;
        return false;
    }
}

//without modifying grid
public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}
