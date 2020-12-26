class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return helper(s, 0, dp);
    }
    public int helper(String s, int index, Integer[] dp){
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (dp[index]!=null) return dp[index];
        
        int ans = helper(s, index + 1, dp);
        if (index < s.length()-1 && (s.charAt(index)=='1' || s.charAt(index)=='2' && s.charAt(index+1)<'7')){
            ans += helper(s, index + 2, dp);
        }
        return dp[index] = ans;
    }
}
