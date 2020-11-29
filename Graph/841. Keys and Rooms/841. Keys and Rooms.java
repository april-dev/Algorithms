public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<List<Integer>> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(rooms.get(0));
        visited.add(0);
        
        while (!queue.isEmpty()){
            List<Integer> cur = queue.remove();
            for (int key:cur){
                if (visited.contains(key)) continue;
                queue.offer(rooms.get(key));
                visited.add(key);
                if (visited.size()==rooms.size()) return true;
            }
        }
        return visited.size()==rooms.size();
    }
    
    
//DFS
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, 0, visited);
        int res = 0;
        for (int i=0; i<visited.length; i++){
            if (visited[i]==true) res++;
        }
        return res==rooms.size()? true:false;
    }
    public void dfs(List<List<Integer>> rooms, int index, boolean[] visited){
        
        for (int key: rooms.get(index)){
            if (visited[key]==true) continue;
            visited[key] =  true;
            dfs(rooms, key, visited);
        }
    }
}
