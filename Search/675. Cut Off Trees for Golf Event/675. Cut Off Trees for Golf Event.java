/*
The worst case time complexity could be O(m^2 * n^2) (m = number of rows, n = number of columns) since there are m * n trees and for each BFS worst case time complexity 
is O(m * n) too.
*/

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        for (int i=0; i<m; i++){
             for (int j=0; j<n; j++){
                 if (forest.get(i).get(j)>1) pq.add(new int[]{i, j, forest.get(i).get(j)});
             }
        }
        int[] start = new int[2];
        int sum = 0;
        while(!pq.isEmpty()){
            int[] curTree = pq.poll();
            int step = minStep(forest, start, curTree, m, n);
            if (step == -1) return -1;
            sum += step;
            start[0] = curTree[0];
            start[1] = curTree[1];            
        }
        return sum;
    }
    public int minStep(List<List<Integer>> forest, int[] start, int[] curTree, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                int[] cur = q.poll();
                if (cur[0]==curTree[0] && cur[1]==curTree[1]) return level;
                
                for (int[] dir:dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    
                    if (x<0 || x>=m || y<0 || y>=n || forest.get(x).get(y)==0 || visited[x][y]==true) continue;
                    q.offer(new int[]{x, y});
                    visited[x][y]=true;;
                }               
            }
            level++;
        }
        return -1;
    }
}
