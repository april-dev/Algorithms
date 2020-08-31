class MapSum {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode temp = root;
        for (char c:key.toCharArray()){
            TrieNode t = temp.child.get(c);
            if (t==null){
                temp.child.put(c, new TrieNode());
            }
            temp = temp.child.get(c);
        }
        temp.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode temp = root;
        for (char c: prefix.toCharArray()){
            if (temp.child.get(c)==null) return 0;
            temp = temp.child.get(c);
        }
        return dfs(temp);
    }
    
    public int dfs(TrieNode root){
        int sum = 0;
        for (char c:root.child.keySet()){
            sum+= dfs(root.child.get(c));
        }
        return sum+root.val;
    }
    
    class TrieNode{
        HashMap<Character, TrieNode> child;
        int val;
        public TrieNode (){
            child = new HashMap<>();
            val = 0;
        }
    }
}
