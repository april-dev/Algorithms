public int calculate(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num*10 + c - '0';
            if (i==s.length()-1 || !Character.isDigit(c) && c != ' '){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                }
                sign= c;
                num = 0;
            }
        }
        int sum = 0;
        for (int i:stack) sum += i;
        return sum;
    }


public int calculate(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num*10 + c-'0';
            if (i == s.length() - 1 ||!Character.isDigit(c) && c != ' '){
                switch (lastSign){
                    case '+':
                        sum += tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum += tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;                        
                }
                num = 0;
                lastSign = c;
            }
            
        }
        sum += tempSum;
        return sum;
    }
