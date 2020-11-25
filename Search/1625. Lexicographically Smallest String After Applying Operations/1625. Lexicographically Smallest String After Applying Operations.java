//BFS
//Time: O(10*N*N), 10*N for add operation, N for rotation
public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String smallest = s;
        int n = s.length();
        queue.add(s);
        visited.add(s);
        
        while (!queue.isEmpty()){
            //int size = queue.size();
            //for (int j=0; j<size; j++){
                String cur = queue.remove();
                if (smallest.compareTo(cur) > 0) smallest = cur;
                char[] ca = cur.toCharArray();
                for (int i=1; i<ca.length; i+=2){
                    ca[i] = (char) ((ca[i] - '0' + a)%10 + '0');
                }
                String addA = String.valueOf(ca);
                if (visited.add(addA)) queue.add(addA);
                String rotate = s.substring(n-b) + s.substring(0, n-b);
                if (visited.add(rotate)) queue.add(rotate);
           // }
        }
        return smallest;
    }

//DFS
class Solution {
    String ans;
    HashSet<String> visited = new HashSet<>();
    public String findLexSmallestString(String s, int a, int b) {
        ans = s;
        dfs(s, a, b);
        return ans;
    }
    public void dfs(String s, int a, int b){
        if (visited.contains(s)) return;
        if (ans.compareTo(s) > 0) ans = s;
        visited.add(s);
        dfs(add(s, a), a, b);
        dfs(rotate(s, b), a, b);        
    }
    public String add(String s, int a){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (i%2 == 0) sb.append(s.charAt(i));
            else sb.append((s.charAt(i) - '0' + a)%10);
        }
        return sb.toString();
    }
    public String rotate(String s, int b){
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
