//Same as Q1081. Smallest Subsequence of Distinct Characters
public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        boolean[] valid = new boolean[26];
        
        for (int i=0; i<s.length(); i++){
            int c = s.charAt(i) - 'a';
            map[c]++;
        }
        
        Stack<Character> stack = new Stack<>();
        //stack.add(s.charAt(0));
        for (int i=0; i<s.length(); i++){
            int cur = s.charAt(i) - 'a';
            if (valid[cur]) {
                map[cur]--;
                continue;
            }
            while (!stack.isEmpty() && cur<(stack.peek() - 'a') && map[stack.peek() - 'a']>1){
                map[stack.peek() - 'a']--;
                valid[stack.peek() - 'a'] = false;
                stack.pop();  
            }
            stack.add(s.charAt(i));
            valid[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        char[] temp = new char[stack.size()];
        for (int i=0; i<temp.length; i++) temp[i] = stack.pop();
        for (int i=temp.length-1; i>=0; i--) sb.append(temp[i]);
        return sb.toString();
    }
