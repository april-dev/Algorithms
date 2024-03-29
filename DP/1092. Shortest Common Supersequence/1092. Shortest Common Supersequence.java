//Q1143 Longest common subsequence
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = longestSubSeq(str1, str2);
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();
        
        for (char c:lcs.toCharArray()){
            while(str1.charAt(i)!=c){
                sb.append(str1.charAt(i));
                i++;
            }
            while(str2.charAt(j)!=c){
                sb.append(str2.charAt(j));
                j++;
            }
            sb.append(c);
            i++;
            j++;
        }
        sb.append(str1.substring(i));
        sb.append(str2.substring(j));
        return sb.toString();   
    }
    public String longestSubSeq(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        String[][] dp = new String[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
                }else{
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length()? dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}


//If use string dp, memory limit exceed beccause ut store the super sequence. using string DP passes in Q1143 Longest common subsequence because it stores sub-sequence
public String shortestCommonSupersequence(String str1, String str2) {
       int m = str1.length();
       int n = str2.length();
       String[][] dp = new String[m + 1][n + 1];
        
       for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if (i==0 && j==0){
                    dp[i][j] = "";
                }else if (i == 0){
                    dp[i][j] = dp[i][j-1] + str2.charAt(j-1);
                }else if (j == 0){
                    dp[i][j] = dp[i-1][j] + str1.charAt(i-1);;
                }else if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                }else{
                    dp[i][j] = dp[i - 1][j].length()<dp[i][j - 1].length()? dp[i-1][j] + str1.charAt(i-1):dp[i][j-1] + str2.charAt(j-1) ;
                }
            }
        }
        return dp[m][n];
    }

//Improve on the previous solution
public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
            }
        }

        int l = dp[m][n]; // Length of the ShortestSuperSequence
        char[] arr = new char[l];
        int i=m, j=n;
        while(i>0 && j>0)
        {
            /* If current character in str1 and str2 are same, then
             current character is part of shortest supersequence */
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                arr[--l] = str1.charAt(i-1);
                i--;j--;
            }else if(dp[i-1][j]<dp[i][j-1]) {
                arr[--l] = str1.charAt(i-1);
                i--;
            }
            else {
                arr[--l] = str2.charAt(j-1);
                j--;
            }
        }
        while (i > 0) {
            arr[--l] = str1.charAt(i-1);
            i--;
        }
        while (j > 0) {
            arr[--l] = str2.charAt(j-1);
            j--;
        }
        return new String(arr);
    }
