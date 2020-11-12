//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
//https://leetcode.com/problems/remove-invalid-parentheses/solution/

//Time: O(2^N) worst case. Pruning below improves time complexity.
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


//BFS
//Time: you have a length n string, every character have 2 states "keep/remove", that is 2^n states and check valid is O(n). All together O(n*2^n).
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
      List<String> res = new ArrayList<>();
      
      // sanity check
      if (s == null) return res;
      
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      
      // initialize
      queue.add(s);
      visited.add(s);
      
      boolean found = false;
      
      while (!queue.isEmpty()) {
        s = queue.poll();
        
        if (isValid(s)) {
          // found an answer, add to the result
          res.add(s);
          found = true;
        }
      
        if (found) continue;
      
        // generate all possible states
        for (int i = 0; i < s.length(); i++) {
          // we only try to remove left or right paren
          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
        
          String t = s.substring(0, i) + s.substring(i + 1);
        
          if (!visited.contains(t)) {
            // for each state, if it's not visited, add it to the queue
            queue.add(t);
            visited.add(t);
          }
        }
      }
      
      return res;
    }
    
    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
      int count = 0;
    
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }
    
      return count == 0;
    }
}
