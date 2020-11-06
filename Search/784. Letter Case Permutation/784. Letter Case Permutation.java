class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(S, 0, sb, res);
        return res;
    }
    public void helper(String S, int i, StringBuilder sb, List<String> res){
        if (i==S.length()){
            String temp = sb.toString();
            res.add(temp);
            return;
        }        
        if (!Character.isLetter(S.charAt(i))){
            sb.append(S.charAt(i));
            helper(S, i+1, sb, res);
            return;
         }
        
        int len = sb.length();
        
        sb.append(Character.toLowerCase(S.charAt(i)));
        helper(S, i+1, sb, res);
        sb.setLength(len);
        
        sb.append(Character.toUpperCase(S.charAt(i)));
        helper(S, i+1, sb, res);
        sb.setLength(len);        
    }
}

//DFS using char array
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }
    
    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }
        
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }
}

//BFS
public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(S);
        for (int i=0; i<S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = q.size();
            for (int j=0; j<size; j++){
                String cur = q.poll();
                char[] curArray = cur.toCharArray();
                curArray[i] = Character.toUpperCase(curArray[i]);
                q.offer(new String(curArray));
                curArray[i] = Character.toLowerCase(curArray[i]);
                q.offer(new String(curArray));
            }
        }
        return new LinkedList<>(q);
    }
