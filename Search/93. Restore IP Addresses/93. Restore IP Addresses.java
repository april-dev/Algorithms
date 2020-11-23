class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 4, new StringBuilder(), res);
        return res;
    }
    public void helper(String s, int index, int k, StringBuilder sb, List<String> res){
         if (k == 0 && index == s.length()){
            res.add(sb.toString());
            return;
        }else if (k<0 || index>s.length()){
             return;
         }
        
        for (int i=1; i<=3; i++){
            if (index+i>s.length()) break;
            int num = Integer.valueOf(s.substring(index, index+i));
            if (i==1 || i==2 && num>=10 && num<=99 || i==3 && num>=100 && num<=255){
                int len = sb.length();
                sb.append(num);
                if (k>1) sb.append(".");
                helper(s, index+i, k-1, sb, res);
                sb.setLength(len);
            }
        }
    }
}
