//line 4, 5 and 21 are different from regular BFS

/*
The key thing to note here is
x = Math.abs(x);
y = Math.abs(y);

Here we are forcing the original co-ordinates to be in 1st Quadrant only. ( since we can use symmetry )

you cannot reach from 0,0 to 1,1 using only 1st quadrant. hence we allow x >=-1 y>=-1 instead of x>=0, y>=0 limit
*/
public int minKnightMoves(int x, int y) {
        int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        x = Math.abs(x);
        y = Math.abs(y);
        Set<String> visited  = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited.add("0-0");
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                int[] cur = q.poll();
            int m = cur[0];
            int n = cur[1];
            if (m==x && n == y) return level;
                for (int[] dir: dirs){
                    int newX = m + dir[0];
                    int newY = n+dir[1];
                    if (!visited.contains(newX + "-" + newY) && newX>=-1 && newY>=-1){
                        q.add(new int[]{newX, newY});
                        visited.add(newX + "-" + newY);
                    }
                }
            }
            level++;
        }
        return -1;
    }
