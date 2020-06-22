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
   
//DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }
    public void dfs(int[][] image, int i, int j, int newColor, int oldColor){
        if (i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=oldColor) return;
        image[i][j] = newColor;
        dfs(image, i+1, j, newColor, oldColor);
        dfs(image, i-1, j, newColor, oldColor);
        dfs(image, i, j-1, newColor, oldColor);
        dfs(image, i, j+1, newColor, oldColor);
    }
