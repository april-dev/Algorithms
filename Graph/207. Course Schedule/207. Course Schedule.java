   //DFS 1. This DFS solution is slow because in the DFS traversal, after it finished the traversal for each node in the for loop (line 14), it marks all the nodes as unvisited. 
   // so for each node, the graph is a whole new graph. Since this kind of graph may have many roots(i.e., node without any incoming edges), and the for loop (line 14) may start from 
   // anywhere in the graph, if you start from the middle, and then move on to its upper level node, the upper level node will still repeat the previous traversal for this child, resulting
   //in repetitve and uncessary inefficiencies. One approach to improve is to identify three states. First state (0) means this node has never been traversed. 1 means this node has been 
   //visited in the current traversal. 2 means this node has been visited and it did not cause a problem. 
   
   public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++)
                graph[i] = new ArrayList();
                
            boolean[] visited = new boolean[numCourses];
            for(int i=0; i<prerequisites.length;i++){
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
            }

            for(int i=0; i<numCourses; i++){
                if(!dfs(graph,visited,i))
                    return false;
            }
            return true;
        }

        private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
            if(visited[course])
                return false;
            else
                visited[course] = true;;

            for(int i=0; i<graph[course].size();i++){
                if(!dfs(graph,visited,(int)graph[course].get(i)))
                    return false;
            }
            visited[course] = false;
            return true;
        }
        
        
   //DFS 2. Improved version. three states.
   public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for (int i=0; i<numCourses; i++){
            courses.add(new ArrayList<>());
        }
        for (int i=0; i<prerequisites.length; i++){
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if (!dfs(i, courses, visited)) return false;
        }
        return true;      
    }
    public boolean dfs(int i, List<List<Integer>> courses, int[] visited){
        if (visited[i]==1) return false;
        if (visited[i]==2) return true;
        
        
        visited[i]=1;
        
        for (int child = 0; child<courses.get(i).size(); child++){
            if (!dfs(courses.get(i).get(child), courses, visited)) return false;
        }
        visited[i] = 2; 
        return true;
    }
