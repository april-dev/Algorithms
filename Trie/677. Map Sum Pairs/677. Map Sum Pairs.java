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
//Solution 2: use two hash tables.
class MapSum {
public:
    /** Initialize your data structure here. */
    MapSum() {}
    
    void insert(const string& key, int val) {
        int inc = val;
        if (vals_.count(key)) {
            inc -= vals_[key];
        }
        vals_[key] = val;
        for (int i = 1; i <= key.length(); ++i)
            sums_[key.substr(0,i)] += inc;
    }
    
    int sum(const string& prefix) {
        return sums_[prefix];
    }
private:
    unordered_map<string, int> vals_;
    unordered_map<string, int> sums_;    
};
