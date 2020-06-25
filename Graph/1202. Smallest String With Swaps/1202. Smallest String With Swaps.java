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
