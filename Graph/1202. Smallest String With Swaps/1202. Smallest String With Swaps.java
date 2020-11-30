    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0) return null;
        int[]parent = new int[s.length()];
        for (int i=0; i<s.length(); i++) parent[i] = i;       
        for(List<Integer> l:pairs){
            int a=find(parent,l.get(0)),b=find(parent,l.get(1));
            if(a!=b) parent[a]=b;
        }
        
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i=0; i<s.length(); i++){
            int root = find (parent, i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(sChar[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            sb.append(map.get(find(parent, i)).poll());
        }
        return sb.toString();
    }
//Path compression    
    public int find(int[] parent,int a){
        if(a!=parent[a])parent[a]=find(parent,parent[a]);
        return parent[a];
    }

//use an array instead of StringBuilder to speed up
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s.length()==0)return "";
        int[] parent=new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        for(List<Integer> l:pairs){
            int a=find(parent,l.get(0)),b=find(parent,l.get(1));
            if(a!=b)parent[a]=b;
        }
        char[] arr=new char[s.length()];
        char[] answer = new char[s.length()];
        arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            int root=find(parent,i);
            map.putIfAbsent(root,new PriorityQueue<>());
            map.get(root).offer(arr[i]);
        }
        for(int i=0;i<s.length();i++){
            int a=parent[i];
            answer[i]=map.get(a).poll();
        }                                                       
        return new String(answer);
    }
    public int find(int[] parent,int a){
        if(a!=parent[a])parent[a]=find(parent,parent[a]);
        return parent[a];
    }

//DFS
class Solution {
    List<Character> indiceString = new ArrayList<>();
    List<Integer> indices = new ArrayList<>();
    boolean[] visited;
    HashMap<Integer, List<Integer>> map;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        map = new HashMap<>();
        visited = new boolean[s.length()];
        for (List<Integer> l:pairs){
            map.putIfAbsent(l.get(0), new ArrayList<>());
            map.putIfAbsent(l.get(1), new ArrayList<>());
            map.get(l.get(0)).add(l.get(1));
            map.get(l.get(1)).add(l.get(0));
        }
        
        char[] str = s.toCharArray();
        for (int i=0; i<s.length(); i++){
            if (visited[i]==true) continue;
            indiceString.clear();
            indices.clear();
            
            dfs(s, i);
            
            Collections.sort(indices);
            Collections.sort(indiceString);
            for (int j=0; j<indices.size(); j++){
                str[indices.get(j)] = indiceString.get(j);
            }            
        }
        return new String(str);
    }
    public void dfs(String s, int i){
        visited[i] = true;
        indices.add(i);
        indiceString.add(s.charAt(i));
        if (map.containsKey(i)){
            for (int cur: map.get(i)){
                if (visited[cur]==true) continue;
                dfs(s, cur);
            }
        }
    }    
}
