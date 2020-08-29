class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = BuildTrie(dictionary);
        String[] tokens = sentence.split(" ");
        return replaceWords(tokens, root);
    }
    private String replaceWords(String[] tokens, TrieNode root){
        StringBuilder sb = new StringBuilder();
        for (String t:tokens){
            sb.append(getShortest(t, root));
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }
    private String getShortest(String token, TrieNode root){
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<token.length(); i++){
            char c = token.charAt(i);
            sb.append(c);
            if (root.child[c-'a']!=null){
                if (root.child[c-'a'].isWord) return sb.toString();  
                root=root.child[c-'a'];
             }else{
                return token;
            }
        }
        return token;
    }
    private TrieNode BuildTrie(List<String> dic){
        TrieNode root = new TrieNode();
        for (String s:dic){
            TrieNode ws = root;
            for (int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if (ws.child[c-'a']==null){
                    ws.child[c-'a'] = new TrieNode();
                }
                ws = ws.child[c-'a'];
            }
            ws.isWord = true;
        }
        return root;
    }
    
    public class TrieNode{
        boolean isWord;
        TrieNode[] child = new TrieNode[26];
        public TrieNode(){}
    }
}
