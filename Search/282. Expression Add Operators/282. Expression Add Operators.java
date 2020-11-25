class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num==null || num.length()==0) return res;
        helper(num, target, "", 0, 0, 0, res);
        return res;
    }
    public void helper(String num, int target, String path, int pos, long eval, long toBeMult, List<String> res){
        if (pos==num.length()){
            if (eval==target) res.add(path);
            return;
        }
        for (int i=pos; i<num.length(); i++){
            //if (i!=pos && num.charAt(i)=='0') break; is wrong
            if (i!=pos && num.charAt(pos)=='0') break;
            long cur = Long.parseLong(num.substring(pos, i+1));
            if (pos==0) helper(num, target, path + cur, i+1, cur, cur, res);
            else {
                helper(num, target, path + "+" + cur, i+1, eval + cur, cur, res);
                helper(num, target, path + "-" + cur, i+1, eval - cur, -cur, res);
                helper(num, target, path + "*" + cur, i+1, eval - toBeMult + toBeMult*cur, toBeMult*cur, res);
            }
        }
    }
}
