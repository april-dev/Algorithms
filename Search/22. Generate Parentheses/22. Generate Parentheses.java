class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, n, "", res);
        return res;
    }
    public void helper(int open, int close, int max, String s, List<String> res){
        if (s.length()==max*2){
            res.add(s);
            return;
        }
        
        if (open<max) helper(open+1, close, max, s + "(", res);
        
        if (close<open) helper(open, close+1, max, s + ")", res);        
    }
}


//faster using stringbuilder
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, 0, n, sb, res);
        return res;
    }
    public void helper(int open, int close, int max, StringBuilder sb, List<String> res){
        if (sb.length()==max*2){
            res.add(sb.toString());
            return;
        }
        if (open<max){
            int len = sb.length();
            helper(open+1, close, max, sb.append("("), res);
            sb.setLength(len);
        }
        if (close<open){
            int len = sb.length();
            helper(open, close+1, max, sb.append(")"), res);
            sb.setLength(len);
        }
    }
}


//Alternative
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, res);
        return res;
    }
    public void helper(int open, int close, StringBuilder sb, List<String> res){
        if (open==0 && close==0){
            res.add(sb.toString());
            return;
        }
        if (open>close) return;
        if (open>0){
            int len = sb.length();
            helper(open-1, close, sb.append("("), res);
            sb.setLength(len);
        }
        if (close>0){
            int len = sb.length();
            helper(open, close-1, sb.append(")"), res);
            sb.setLength(len);
        }
    }
}
