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
