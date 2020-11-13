class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, TrieNode root, int i, int j, List<String> res){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        
        char c = board[i][j];
        if (c=='#' || root.next[c-'a']==null) return;        
        root = root.next[c-'a'];
        if (root.word!=null){
            res.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '#';
        dfs(board, root, i+1, j, res);
        dfs(board, root, i-1, j, res);
        dfs(board, root, i, j+1, res);
        dfs(board, root, i, j-1, res);
        board[i][j] = c;
    }
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String s:words){
            TrieNode p = root;
            for (char c:s.toCharArray()){
                if (p.next[c-'a']==null) p.next[c-'a']= new TrieNode();
                p = p.next[c-'a'];
            }
            p.word = s;
        }
        return root;
    }
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
