//BFS 1
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int m = image.length, n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] offset = {{1,0}, {0,1}, {-1,0}, {0,-1}};
            
        queue.offer(new int[]{sr,sc});
        
        int oldColor = image[sr][sc];
//only the first item in the queue needs to be updated manually, all of the following items will be updated when they are added to the queue (line 20)
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

//BFS 2
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor==oldColor) return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()){
            int[] cur = q.remove();
         //update color when it is popped from the queue
            image[cur[0]][cur[1]] = newColor;
            for (int[] dir:dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x>=0 && x<image.length && y>=0 && y<image[0].length && image[x][y]==oldColor){
                    q.add(new int[]{x, y});
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
