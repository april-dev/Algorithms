public int minPushBox(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] start = new int[2]; 
        int[] target = new int[2];
        int[] box = new int[2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = grid[i][j];
                if(ch=='T'){
                    target = new int[]{i, j};
                }
                if(ch=='S'){
                    start = new int[]{i, j};
                }
                if(ch=='B'){
                    box = new int[]{i, j};
                }
            }
        }
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));
        int[] init = new int[]{dist(box[0],box[1], target[0],target[1]), 0, start[0], start[1], box[0], box[1]};
        pq.offer(init);
        Set<String> set = new HashSet();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int moves = cur[1];
            int sx = cur[2], sy = cur[3];
            int bx = cur[4], by = cur[5];
            if(bx==target[0] && by==target[1]) return moves;
            String ss = sx+":"+sy+"|"+bx+":"+by;
            if(set.contains(ss)) continue;
            set.add(ss);
            for(int[] dir:dirs){
                int nx = sx+dir[0];
                int ny = sy+dir[1];
                if(!valid(nx, ny, m, n, grid))continue;
                int[] next;
                if(nx==bx && ny==by){
                    int nbx = bx+dir[0];
                    int nby = by+dir[1];
                    if(!valid(nbx, nby, m, n, grid)) continue;
                    next = new int[]{dist(nbx, nby, target[0], target[1])+moves+1, moves+1, nx, ny, nbx, nby};
                }else{
                    next = new int[]{cur[0], moves, nx, ny, bx, by};
                }
                pq.offer(next);
            }
        }
        return -1;
    }
    
    private boolean valid(int x, int y, int m, int n, char[][] g){
        if(x<0||x>n-1||y<0||y>m-1|| g[x][y]=='#') return false;
        return true;
    }
    
    private int dist(int x, int y, int tx, int ty){
        return Math.abs(x-tx)+Math.abs(y-ty);
    }
