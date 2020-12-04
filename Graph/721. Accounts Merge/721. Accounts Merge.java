    /**
     * Solution 1: Union Find
     *
     * Use two hash map with union find class to solve the problem
     *  one to one mapping: mail string to its parent index mapping
     *  one to many mapping: parent index to all emails that belong to same group mapping
     * */
 class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for (int i=0; i<parent.length; i++) parent[i] = i;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<accounts.size(); i++){
            List<String> account = accounts.get(i);
            for (int j=1; j<account.size(); j++){
                String s = account.get(j);
                if (!map.containsKey(s)) map.put(s, i);
                else union(parent, i, map.get(s));                
            }
        }
              
        HashMap<Integer, HashSet<String>> resMap = new HashMap<>();        
        for (int i=0; i<parent.length; i++){
            int p = find(parent, i);
            resMap.putIfAbsent(p, new HashSet<>());
            for (int j=1; j<accounts.get(i).size(); j++) resMap.get(p).add(accounts.get(i).get(j));
        }
        
        List<List<String>> res = new ArrayList<>();
        for (int key:resMap.keySet()){
            List<String> temp = new ArrayList<>(resMap.get(key)); 
            Collections.sort(temp);
            temp.add(0, accounts.get(key).get(0));
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
     
    public int find(int[] parent, int i){
        if (parent[i] != i){
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
     
    public void union(int[] parent, int a, int b){
        int p1 = find(parent, a);
        int p2 = find(parent, b);
        if (p1!=p2) parent[p1] = p2;
    }
}




    /**
     * Solution 2: Graph + BFS
     *
     * @params graph: one to many mapping graph that connects all emails with same name. The graph may contain several
     * separated components
     * @params emailToName: one to one mapping for finding name by any email belong to same group
     * */
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // step 1: build graph that connects all emails have relationships
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), name);
                if (i != 1) {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }

        // step 2: BFS traversal to traverse all nodes in every single component and generate each result list individually
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> newList = bfs(graph, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                result.add(newList);
            }
        }
        return result;
    }

    public List<String> bfs(Map<String, Set<String>> graph, Set<String> visited, String startPoint) {
        List<String> newList = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startPoint);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curEmail = queue.poll();
                newList.add(curEmail);
                Set<String> neighbors = graph.get(curEmail);
                for (String neighbor : neighbors) {
                    // WARING: DO NOT FORGET to check whether current email has been visited before
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return newList;
    }





    /**
     * Solution 3: Build graph + DFS
     *
     * @params graph: one to many mapping graph that connects all emails with same name. The graph may contain several
     * separated components
     * @params emailToName: one to one mapping for finding name by any email belong to same group
     * */
    public List<List<String>> accountsMerge3(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // step 1: build graph that connects all emails have relationships
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), name);
                if (i != 1) {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }

        // step 2: DFS traversal to traverse all nodes in every single component and generate each result list individually
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> newList = new ArrayList<>();
                dfs(newList, graph, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                result.add(newList);
            }
        }
        return result;
    }

    public void dfs(List<String> result, Map<String, Set<String>> graph, Set<String> visited, String curPoint) {
        result.add(curPoint);
        Set<String> neighbors = graph.get(curPoint);
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(result, graph, visited, neighbor);
            }
        }
    }
