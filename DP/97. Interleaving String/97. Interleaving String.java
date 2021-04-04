//DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position.
public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n!=s3.length()) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (i==0 && j==0) {
                    dp[i][j] = true;
                }else if (i==0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
                }else if (j==0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                }else{
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)) ;
                }
            }
        }
        return dp[m][n];
    }


//Recursive + memo
public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n!=s3.length()) return false;
         boolean[][] invalid = new boolean[m+1][n+1];
       
        return helper(s1, s2, s3, 0, 0, 0, invalid);
    }
    public boolean helper(String s1, String s2, String s3, int l1, int l2, int l3, boolean[][] invalid){
        if (invalid[l1][l2]) return false;
        if (l3==s3.length()) return true;
        boolean valid = 
            l1<s1.length() && s1.charAt(l1)==s3.charAt(l3) &&  helper(s1, s2, s3, l1+1, l2, l3+1, invalid) || 
            l2<s2.length() && s2.charAt(l2)==s3.charAt(l3) &&  helper(s1, s2, s3, l1, l2+1, l3+1, invalid);
        if (!valid) invalid[l1][l2] = true;
        
        return valid;
    }

//Recursive + memo
class Solution {
public:
  bool isInterleave(string s1, string s2, string s3) {
    m_ = vector<vector<int>>(s1.length() + 1, vector<int>(s2.length() + 1, INT_MIN));
    return dp(s1, s1.length(), s2, s2.length(), s3, s3.length());
  }
private:
  // m_[i][j]: whehter s3[0:i+j] is a interleva of s1[0:i] and s2[0:j]
  vector<vector<int>> m_;
  
  bool dp(const string& s1, int l1, const string& s2, int l2, const string& s3, int l3) {
    if (l1 + l2 != l3) return false;
    if (l1 == 0 && l2 == 0) return true;
    if (m_[l1][l2] != INT_MIN) return m_[l1][l2];
    if (l1 > 0 & s3[l3 - 1] == s1[l1 - 1] && dp(s1, l1 - 1, s2, l2, s3, l3 - 1)
      ||l2 > 0 & s3[l3 - 1] == s2[l2 - 1] && dp(s1, l1, s2, l2 - 1, s3, l3 - 1))
      m_[l1][l2] = 1;
    else
      m_[l1][l2] = 0;
    return m_[l1][l2];
  }
};
