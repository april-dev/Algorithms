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

//DFS approach
public:
    vector<int> indices;                                                 //Stores indices of same group.
    vector<bool> visited;
    vector<vector<int>> adjList;
    string indiceString;                                                 //Stores  string formed by indices in the same group.
    void dfs(string &s,int n)                                             //DFS to get all indices in same group.
    {
        visited[n]=true;
        indices.push_back(n);
        indiceString+=s[n];
        for(int &i:adjList[n])
            if(!visited[i])
               dfs(s,i);
    }
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) 
    {
        adjList.resize(s.length());
        visited.resize(s.length(),false);
        for(vector<int> &v:pairs)                               //Create adjacency list using the indice pairs
            adjList[v[0]].push_back(v[1]),adjList[v[1]].push_back(v[0]);
        for(int i=0;i<s.length();i++)
            if(!visited[i])
            {
                indiceString="";                              //Clear string formed by one group of indices before finding next group.
                indices.clear();                             //Clear indices vector before finding another group.
                dfs(s,i);
                sort(indiceString.begin(),indiceString.end());                    //Sort the characters in the same group.
                sort(indices.begin(),indices.end());                                  //Sort the indices in the same group.            
                for(int i=0;i<indices.size();i++)          //Replace all the indices in the same group with the sorted characters.
                    s[indices[i]]=indiceString[i];
            }
        return s;
    }

