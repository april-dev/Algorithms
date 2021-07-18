class Solution {
    public String longestPalindrome(String s) {
        int idx = 0, max = 0;
        for (int i=0; i<s.length(); i++){
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i+1);
            if (max<Math.max(len1, len2)){
                idx= len1>len2? (i-len1/2):(i-len2/2+1);
                max = Math.max(len1, len2);
            }
        }
        return s.substring(idx, idx+max);
    }
    public int helper(String s, int i, int j){
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--; j++;
        }
        return j-i-2+1;
    }
}

//DP
class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int i=n-1; i>=0; i--){
            for (int j=i; j<n; j++){
                dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                if (dp[i][j] && (res.length()==0 || j-i+1 > res.length())){
                    res = s.substring(i, j+1);
                }                    
            }
        }
        return res;
    }    
}
