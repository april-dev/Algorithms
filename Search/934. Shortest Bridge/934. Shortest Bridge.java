/*
     Use DFS + BFS to solve this problem
     Step 1: use DFS to mark the first island to another number
     Step 2: start from the first island, doing BFS level order traversal to find number of bridges (levels)
*/

//Time:  DFS is O(m * n) and BFS is also O(m * n) so total O(m * n)
//space complexity is also O(m * n ) for queue and visited set

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        boolean found = false;
        
        for (int i=0; i<m; i++){
            if (found) break;
            for (int j=0; j<n; j++){
                if (A[i][j]==1) {
                    dfs(A, i, j, visited, q);
                    found = true;
                    break;
                }
            }
        }
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                int[] cur = q.poll();
                for (int[] dir:dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x>=0 && x<m && y>=0 && y<n && !visited[x][y]){
                        if (A[x][y]==1) return level;
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }                   
                }
            }
            level++;
        }
        return -1;
    }
    public void dfs(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> q){
        if (i<0 || i>=A.length || j<0 || j>=A[0].length || visited[i][j] || A[i][j]==0) return;
        q.add(new int[]{i, j});
        visited[i][j] = true;
        for (int[] dir: dirs) dfs(A, i+dir[0], j+dir[1], visited, q);
    }
}
