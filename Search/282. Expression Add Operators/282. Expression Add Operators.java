//There are n-1 slots for us to add an operator and there are 4 choices (+, -, * and no operator) so the complexity is 4^(N-1).
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


//using stringbuilder
public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
   	StringBuilder sb = new StringBuilder();
    dfs(res, sb, num, 0, target, 0, 0);
    return res;
    
}
public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) { 
	if(pos == num.length()) {
		if(target == prev) res.add(sb.toString());
		return;
	}
	for(int i = pos; i < num.length(); i++) {
		if(num.charAt(pos) == '0' && i != pos) break;
		long curr = Long.parseLong(num.substring(pos, i + 1));
		int len = sb.length();
		if(pos == 0) {
			dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
			sb.setLength(len);
		} else {
			dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
			sb.setLength(len);
			dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
			sb.setLength(len);
			dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
			sb.setLength(len);
		}
	}
}
