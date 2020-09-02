class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i=0; i<words.length; i++){
            String s = words[i];
            for (int j=0; j<=s.length(); j++){
                root.insert(s.substring(j, s.length()) + '{' + s, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return root.startWith(suffix + '{' + prefix);
    }
    class TrieNode {
        int idx;
        TrieNode[] child;
        public TrieNode(){
            idx=0;
            child = new TrieNode[27];
        }
    
    public void insert(String word, int idx){
        TrieNode temp = root;
        for (char c:word.toCharArray()){
            if(temp.child[c-'a']==null){
                temp.child[c-'a']=new TrieNode();
            }
            temp = temp.child[c-'a'];
            temp.idx = idx;
        }
    }
    public int startWith(String s){
        TrieNode temp = root;
        for (char c:s.toCharArray()){
            if (temp.child[c-'a']==null) return -1;
            temp = temp.child[c-'a'];
        }
        return temp.idx;
    }
    }
}

// getting hash of the string is linear to the length of the string, so map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w); also takes O(L) time for calculating hash. 
//Therefore time complexity is O(NL^3)

class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for(int w = 0; w < words.length; w++){
            for(int i = 0; i <= 10 && i <= words[w].length(); i++){
                for(int j = 0; j <= 10 && j <= words[w].length(); j++){
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return (map.containsKey(prefix + "#" + suffix))? map.get(prefix + "#" + suffix) : -1;
    }
}
