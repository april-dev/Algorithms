//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
//https://leetcode.com/problems/remove-invalid-parentheses/solution/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                left++;
            }else if (s.charAt(i)==')'){
                if (left>0) left--;
                else right++;
            }
        }
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, sb, left, right, 0, res);
        return new ArrayList<String>(res);
        
    }
    public void dfs(String s, int i, StringBuilder sb, int left, int right, int open, Set<String> res){
        if (left<0 || right<0 || open<0 ) return;
        if (i==s.length()){
            if (left==0 && right==0 && open==0) res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if (s.charAt(i)=='('){
            dfs(s, i+1, sb, left-1, right, open, res);
            dfs(s, i+1, sb.append('('), left, right, open+1, res);
        }else if (s.charAt(i)==')'){
            dfs(s, i+1, sb, left, right-1, open, res);
            dfs(s, i+1, sb.append(')'), left, right, open-1, res);
        }else{
            dfs(s, i+1, sb.append(s.charAt(i)), left, right, open, res);
        }
        sb.setLength(len);
    }
}
