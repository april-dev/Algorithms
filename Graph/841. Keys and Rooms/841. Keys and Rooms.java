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
    
    
    
      public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>(); seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }


HashSet<Integer> enteredRooms = new HashSet<>();

public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    enterRoom(0, rooms);
    return enteredRooms.size() == rooms.size();
}

private void enterRoom(int roomId, List<List<Integer>> rooms) {
    enteredRooms.add(roomId);
    List<Integer> keysInRoom = rooms.get(roomId);
    for (int key: keysInRoom)
        if (!enteredRooms.contains(key))
            enterRoom(key, rooms);
}
