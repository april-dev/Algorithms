public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (int i=0; i<S.length(); i++){
            if (S.charAt(i)=='('){
                stack.push(cur);
                cur = 0;
            }else{
                cur = stack.pop()+Math.max(2*cur, 1);
            }
        }
        return cur;
         
     }

//
class Solution {
    int i=0;
    public int scoreOfParentheses(String S) {
       int ans = 0;
        while (i<S.length()){
            char c = S.charAt(i++);
            if (c=='('){
                if (S.charAt(i)==')'){
                    ans += 1;
                    i++;
                }else{
                    ans += 2* scoreOfParentheses(S);
                }
            }else return ans;
        }
        return ans;
    }
}
 
