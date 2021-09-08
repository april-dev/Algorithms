public char[][] updateBoard(char[][] board, int[] click) {
        int[][] dirs = {{1,-1}, {1,1}, {-1,1}, {-1,-1}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int m = board.length, n = board[0].length;
        if (board[click[0]][click[1]]=='M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        q.add(new int[]{click[0], click[1]});
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int count = 0;
            for (int[] dir: dirs){
                int x1 = x+dir[0], y1 = y+dir[1];
                if (x1<0 || x1>=m || y1<0 || y1>=n ) continue;
                if (board[x1][y1]=='M') count++;                  
            }
            
            if (count!=0) board[x][y] = (char) (count+'0');
            else {
                board[x][y] = 'B';
                for (int[] dir: dirs){
                    int x1 = x+dir[0], y1 = y+dir[1];
                    if (x1<0 || x1>=m || y1<0 || y1>=n ) continue;
                    if (board[x1][y1] == 'E'){
                        q.add(new int[] {x1,y1});
                        board[x1][y1] = 'B';
                    }                        
                }                   
            }            
        }
        return board;
    }
