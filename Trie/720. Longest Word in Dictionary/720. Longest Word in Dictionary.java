//Trie + sorting
class MagicDictionary {
    Map<String, HashSet<Character>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for (String s:dictionary){
            for (int i=0; i<s.length(); i++){
                String temp =s.substring(0, i) +"*" + s.substring(i+1);
                HashSet<Character> set = map.getOrDefault(temp, new HashSet<>());
                set.add(s.charAt(i));
                map.put(temp, set);
            }
        }
    }
    
    public boolean search(String searchWord) {
        char[] s = searchWord.toCharArray();
        for (int i=0; i<searchWord.length(); i++){
            char c = s[i];
            s[i] = '*';
            String t = new String(s);
            if (map.containsKey(t)){
                HashSet set = map.get(t);
                if (!set.contains(c) || set.size()>1) return true;
            }
            s[i] = c;
        }
        return false;
    }
}


//Trie + No sorting
class Solution {
    TrieNode root = new TrieNode();
    public String longestWord(String[] words) {
        buildTrie(words);
        String best = "";
        for (String s:words){
            if (s.length()<best.length() || s.length()==best.length() && best.compareTo(s)<0) continue;
           if (hasAllPrefixes(s)) best = s;  
        }
        return best;
    }
    public boolean hasAllPrefixes(String word){
        TrieNode temp = root;
        for (char c:word.toCharArray()){
            if (!temp.child[c-'a'].isWord) return false;
            temp = temp.child[c-'a'];
        }
        return true;
    }
    
    public void buildTrie(String[] words){
        for (String s:words){
            TrieNode temp = root;
            for (char c:s.toCharArray()){
                if(temp.child[c-'a']==null){
                    temp.child[c-'a'] = new TrieNode();
                }
                temp = temp.child[c-'a'];
            }
            temp.isWord = true;
        }
    }
    
    public class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isWord;
        public TrieNode(){}
        
    }
}

//Hashset + No sorting
class Solution {
public:
    string longestWord(vector<string>& words) {
        string best;        
        unordered_set<string> dict(words.begin(), words.end());
        
        for (const string& word : words) {
            if (word.length() < best.length() 
             || (word.length() == best.length() && word > best)) 
                continue;
            string prefix;
            bool valid = true;
            for (int i = 0; i < word.length() - 1 && valid; ++i) {
                prefix += word[i];
                if (!dict.count(prefix)) valid = false;
            }
            if (valid) best = word;
        }
        
        return best;
    }


//HashSet + sorting
public:
    string longestWord(vector<string>& words) {
        // Sort by length DESC, if there is a tie, sort by lexcial order.
        std::sort(words.begin(), words.end(), 
                  [](const string& w1, const string& w2){
                    if (w1.length() != w2.length()) 
                        return w1.length() > w2.length();
                    return w1 < w2;
                  });
        
        unordered_set<string> dict(words.begin(), words.end());
        
        for (const string& word : words) {
            string prefix;
            bool valid = true;
            for (int i = 0; i < word.length() - 1 && valid; ++i) {
                prefix += word[i];
                if (!dict.count(prefix)) valid = false;
            }
            if (valid) return word;
        }
        
        return "";
    }
    
    //Hashset + sorting
    class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
