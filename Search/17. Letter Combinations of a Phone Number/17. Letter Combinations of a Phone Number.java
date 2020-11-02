//BFS Queue
//number 7 has 4 letters, Time Complexity: O(4^n), space: O(n^4) 
public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length()==0) return ans;
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i=0; i<digits.length(); i++){
            int cur = digits.charAt(i) - '0';
            while (ans.peek().length()==i){
                String t = ans.remove();
                for (char s:map[cur].toCharArray()){
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }
    
    
//Without first for loop, time complexity is the same
public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length()==0) return ans;
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        
            
            while (ans.peek().length()!=digits.length()){
                String t = ans.remove();
                int cur = digits.charAt(t.length()) - '0';
                for (char s:map[cur].toCharArray()){
                    ans.add(t+s);
                }
            }
        
        return ans;
    }


//DFS
class Solution {
    private  static final String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length()==0) return ans;
        helper(digits, 0, "", ans);
        return ans;
    }
    public void helper(String digits, int index, String prefix, LinkedList<String> ans){
        if (index==digits.length()){
            ans.add(prefix);
            return;
        }
        String key = map[digits.charAt(index) - '0'];
        for (int i=0; i<key.length(); i++){
            helper(digits, index+1, prefix + key.charAt(i), ans);
        }
    }  
}


//DFS
//use StringBuilder
//faster
class Solution {
    private  static final String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length()==0) return ans;
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, ans);
        return ans;
    }
    public void helper(String digits, int index, StringBuilder sb, LinkedList<String> ans){
        if (index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String key = map[digits.charAt(index) - '0'];
        for (int i=0; i<key.length(); i++){
            int len = sb.length();
            helper(digits, index+1, sb.append(key.charAt(i)), ans);
            sb.setLength(len);
        }
    }   
}
