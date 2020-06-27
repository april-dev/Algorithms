// only difference with 207 is line 31. Post order traversal can be used to return topological sort orders. 

public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++){
            map[i] = new ArrayList<>();
        }
        for (int i=0; i<prerequisites.length; i++){
            map[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            if (!dfs(map, i, visited, res)) return new int[0];
        }
        int[]result = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            result[i] = res.get(res.size()-1-i);
        }
        return result;
    }
    public boolean dfs(List<Integer>[] map, int i, int[] visited, List<Integer> res){
        if (visited[i]==1) return false;
        if (visited[i]==2) return true;
        
        visited[i] = 1;
        for (int child:map[i]){
            if (!dfs(map, child, visited, res)) return false;
        }
        visited[i] = 2;
        res.add(i);
        return true;
    }
    
    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            map[i] = new ArrayList<>();
        }
        for (int i=0; i<prerequisites.length; i++){
            map[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]] += 1;
        }
        int[]res= new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        //int numEdges = prerequisites.length;
        for (int i=0; i<numCourses; i++){
            if (inDegree[i]==0) q.add(i);
        }
        while (!q.isEmpty()){
            int cur = q.remove();
            res[index++] = cur;
            for (int child:map[cur]){
                inDegree[child]-=1;
                //numEdges -= 1;
                if (inDegree[child]==0) q.add(child);
            }
        }
        return index==numCourses?res: new int[0];

    }
