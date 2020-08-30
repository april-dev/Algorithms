//if k is the average length of input string, then O(nk) for building the Trie and O(26k^2) for searching the Trie.

class MagicDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s:dictionary){
            TrieNode temp = root;
            for (int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if (temp.child[c-'a']==null){
                    temp.child[c-'a'] = new TrieNode();
                }
                temp = temp.child[c-'a'];
            }
            temp.isWord = true;
        }
    }
    
    public boolean search(String searchWord) {
        char[] s = searchWord.toCharArray();
        for (int i=0; i<searchWord.length(); i++){
            for (char c='a'; c<='z'; c++){
                if (s[i]==c) continue;
                char orig = s[i];
                s[i] = c;
                if (contains(s)) return true;
                s[i] = orig;
            }
        }
        return false;
    }
    private boolean contains(char[] word){
        TrieNode temp = root;
        for (int i=0; i<word.length; i++){
            if (temp.child[word[i]-'a']==null) return false;
            temp = temp.child[word[i]-'a'];
        }
        return temp.isWord;
    }
    
    public class TrieNode {
        boolean isWord;
        TrieNode[] child = new TrieNode[26];
        public TrieNode(){}
    }
}


//fuzzy search
/*
Time Complexity:
buildDict: O(n*m)
n: numbers of words
m: length of word
search: O(m)
m: length of word
Space Complexity:
O(n*m)
/*
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
