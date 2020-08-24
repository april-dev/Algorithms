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
