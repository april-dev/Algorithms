public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j]==0) queue.offer(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int level = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] cur = queue.poll();
                for (int[] dir:dirs){
                    int x = cur[0]+dir[0];
                    int y = cur[1]+dir[1];
                    if (x<0 || x>=m || y<0 || y>=n || matrix[x][y]<=matrix[cur[0]][cur[1]]+1) continue;
                    queue.offer(new int[]{x, y});
                    matrix[x][y] = matrix[cur[0]][cur[1]]+1;
                }
            }
        }
        return matrix;
    }
