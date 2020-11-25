//my solution
class Solution {
    List<Long> res = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        dfs(S, 0,  ans);
        return ans;
    }
    public boolean dfs(String s, int index, List<Integer> ans){
        if ( ans.size()>=3 && ans.get(ans.size()-1) !=  ans.get(ans.size()-2)+  ans.get(ans.size()-3)){
            return false;
        }else if (index==s.length() && ans.size()>=3){
            return true;
        }

        for (int i=index; i<s.length(); i++){
            if (i!=index && s.charAt(index)=='0') break;

            long cur = Long.valueOf(s.substring(index, i+1));
            if (cur>Integer.MAX_VALUE) break;
            if (ans.size()>=2 && cur> ans.get(ans.size()-1)+ ans.get(ans.size()-2)) break;
            
             ans.add((int)cur);
            if (dfs(s, i+1, ans)) return true;
             ans.remove( ans.size()-1);
        }
        return false;
    }
}

//faster solution
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        dfs(S, 0,  ans);
        return ans;
    }
    public boolean dfs(String s, int index, List<Integer> ans){
        if (index==s.length() && ans.size()>=3) return true;

        for (int i=index; i<s.length(); i++){
            if (i!=index && s.charAt(index)=='0') break;

            long cur = Long.valueOf(s.substring(index, i+1));
            if (cur>Integer.MAX_VALUE) break;
            
            int size = ans.size();
            if (size>=2 && cur> ans.get(size-1)+ ans.get(size-2)) break;
            
            if (size<=1 || cur ==  ans.get(size-1)+  ans.get(size-2)){
                 ans.add((int)cur);
                 if (dfs(s, i+1, ans)) return true;
                 ans.remove( ans.size()-1);
            }            
        }
        return false;
    }
}
