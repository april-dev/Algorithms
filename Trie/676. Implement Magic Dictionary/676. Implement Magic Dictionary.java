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
