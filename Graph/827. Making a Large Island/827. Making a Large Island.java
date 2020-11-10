//My solution
class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> area = new HashMap<>();
        int index = 2, N = grid.length, res = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (grid[i][j]==1){
                    area.put(index, dfs(grid, i, j, index));
                    //in case there is no 0 in the  grid, e.g., [[1]].
                    res = Math.max(res, area.get(index++));
                }
            }
        }
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (grid[i][j]==0){
                    int size = 1;
                    HashSet<Integer> visited = new HashSet<>();
                    for (int[] dir:dirs){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if (isValid(x, y, N) && grid[x][y]>1 && !visited.contains(grid[x][y])) {
                            size+=area.get(grid[x][y]);
                            visited.add(grid[x][y]);
                        }
                    }
                res = Math.max(res, size);    
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int x, int y, int index){
        if (isValid(x, y, grid.length)==false || grid[x][y]!=1) return 0;
        grid[x][y] = index;
        int area = 0;
        area = dfs(grid, x+1, y, index) +
            dfs(grid, x-1, y, index) +
            dfs(grid, x, y+1, index) +
            dfs(grid, x, y-1, index);
        return 1+area;
    }
    public boolean isValid(int x, int y, int N){
        return x>=0 && x<N && y>=0 && y<N;
    }
}





import javafx.util.Pair;
class Solution {
    public int N = 0;
    public int largestIsland(int[][] grid) {
        N = grid.length;
        //DFS every island and give it an index of island
        int index = 3, res = 0;
        HashMap<Integer, Integer> area = new HashMap<>();
        for (int x = 0; x < N; ++x) for (int y = 0; y < N; ++y)
            if (grid[x][y] == 1) {
                area.put(index, dfs(grid, x, y, index));
                res = Math.max(res, area.get(index++));
            }

        //traverse every 0 cell and count biggest island it can conntect
        for (int x = 0; x < N; ++x) for (int y = 0; y < N; ++y)
            if (grid[x][y] == 0) {
                HashSet<Integer> seen = new HashSet<>();
                int cur = 1;
                for (Pair<Integer, Integer> p : move(x, y)) {
                    index = grid[p.getKey()][p.getValue()];
                    if (index > 1 && !seen.contains(index)) {
                        seen.add(index);
                        cur += area.get(index);
                    }
                }
                res = Math.max(res, cur);
            }
        return res;
    }

    public List <Pair<Integer, Integer>> move(int x, int y) {
        ArrayList <Pair<Integer, Integer>> res = new ArrayList<>();
        if (valid(x, y + 1)) res.add(new Pair<Integer, Integer>(x, y + 1));
        if (valid(x, y - 1)) res.add(new Pair<Integer, Integer>(x, y - 1));
        if (valid(x + 1, y)) res.add(new Pair<Integer, Integer>(x + 1, y));
        if (valid(x - 1, y)) res.add(new Pair<Integer, Integer>(x - 1, y));
        return res;
    }

    public boolean valid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public int dfs(int[][] grid, int x, int y, int index) {
        int area = 0;
        grid[x][y] = index;
        for (Pair<Integer, Integer> p : move(x, y))
            if (grid[p.getKey()][p.getValue()] == 1)
                area += dfs(grid, p.getKey(), p.getValue(), index);
        return area + 1;
    }
}
