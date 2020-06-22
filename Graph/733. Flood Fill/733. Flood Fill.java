 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int m = image.length, n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] offset = {{1,0}, {0,1}, {-1,0}, {0,-1}};
            
        queue.offer(new int[]{sr,sc});
        
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while (!queue.isEmpty()){
            int[] cur = queue.remove();
            //image[cur[0]][cur[1]] = newColor;
            for (int[] dir:offset){
                int x = cur[0]+dir[0];
                int y = cur[1]+dir[1];
                if (x>=0 && x<m && y>=0 && y<n && image[x][y]==oldColor){
                    image[x][y] = newColor;
                    queue.offer(new int[]{x,y});
                } 
            }
        }
        return image;
    }
    
