public String decodeString(String s) {
        Stack<Integer> intstack = new Stack<>();
        Stack<StringBuilder> stringstack = new Stack<>();
        String res ="";
        StringBuilder cur = new StringBuilder();
        int k=0;
        for (char ch:s.toCharArray()){
            if (Character.isDigit(ch)){
                k = k*10 + ch - '0';
            }else if (ch=='['){
                intstack.push(k);
                k = 0;
                stringstack.push(cur);
                cur = new StringBuilder();
            }else if (ch==']'){
                int count = intstack.pop();
                StringBuilder tmp = cur;
                cur = stringstack.pop();
                for (int i=0; i<count; i++){
                    cur.append(tmp);
                }
                
            }else{
                cur.append(ch);
            }
        }
        return cur.toString();
    }
