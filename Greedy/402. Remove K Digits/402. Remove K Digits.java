    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack<>();
        int i=0;
        if (k==num.length()) return "0";
        while (i<n){
            while (k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
            i++;
        }
       // The function of this part of code is :
       // 1. in case of 11111 (duplicate)
       // 2. in case of 12345 (ascending order number)
        while (k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //deleteCharAt is a linear time operation. If you remove a character at the head, the characters will have to be moved forward by one position each time. 
        //On the other hand, removing the tail character can be achieved in constant time as there would be no shifting involved
        while (sb.length()>1 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
