//Same as Q1081. Smallest Subsequence of Distinct Characters
//also a Greedy Question
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


//Leetcode solution
public String removeDuplicateLetters(String sr) {

    int[] res = new int[26]; //will contain number of occurences of character (i+'a')
    boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
    char[] ch = sr.toCharArray();
    for(char c: ch){  //count number of occurences of character 
        res[c-'a']++;
    }
    Stack<Character> st = new Stack<>(); // answer stack
    int index;
    for(char s:ch){ 
        index= s-'a';
        res[index]--;   //decrement number of characters remaining in the string to be analysed
        if(visited[index]) //if character is already present in stack, dont bother
            continue;
        //if current character is smaller than last character in stack which occurs later in the string again
        //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
        while(!st.isEmpty() && s<st.peek() && res[st.peek()-'a']!=0){ 
            visited[st.pop()-'a']=false;
        }
        st.push(s); //add current character and mark it as visited
        visited[index]=true;
    }

    StringBuilder sb = new StringBuilder();
    //pop character from stack and build answer string from back
    while(!st.isEmpty()){
        sb.insert(0,st.pop());
    }
    return sb.toString();
}
