//BitMask + BFS
//Time: O(2^n * n^2), Space: O(n^2)
class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] ans = new int[n-1];
        for (int i=1; i<Math.pow(2, n); i++){
            int d = maxDistance(i, n, edges);
            if (d>0) ans[d-1]++;
        }
        return ans;
    }
    public int maxDistance(int state, int n, int[][] edges){
        Set<Integer> cities = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (((state>>i)& 1 )== 1) cities.add(i);
        }
        for (int[] edge:edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            if (cities.contains(u) && cities.contains(v)){
                map.putIfAbsent(u, new ArrayList<>());
                map.putIfAbsent(v, new ArrayList<>());
                map.get(u).add(v);
                map.get(v).add(u);
            }
        }
        int ans = 0;
        for (int city:cities){
            int[] res = bfs(map, city);
            //check if it is connected
            if (res[1]<cities.size()) return 0;
            //If it is connected, find max distance
            ans = Math.max(ans, res[0]);
        }
        return ans;
    }
    public int[] bfs(Map<Integer, List<Integer>> map, int src){
        int[] ans = new int[2];
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        visited.add(src);
        int maxDist = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                int[] cur = q.remove();
                maxDist = Math.max(maxDist, cur[1]);
                
                List<Integer> nei = map.get(cur[0]);
                if (nei!=null){
                for (int j=0; j<nei.size(); j++){
                    if (visited.contains(nei.get(j))) continue;
                    q.add(new int[]{nei.get(j), cur[1]+1});
                    visited.add(nei.get(j));
                } 
                }
            }
        }
        ans[0] = maxDist;
        ans[1] = visited.size();
        return ans;
    }
}


//Can be imporved to O(2^n * n)
//Instead of running BFS for every point in the subset to find maxDist, runing BFS twice is enough because
//For any given node a of the tree, a farthest node b from a must be one of the end points of a path with maximal length. 
//i.e. there exists a path from b to c whose length is maximal.




