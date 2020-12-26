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

public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7')) 
					dp[i]+=dp[i+2];
            }
        return dp[0];   
    }


//from left to right
public int numDecodings(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
               dp[i] = dp[i-1];  
	       //dp[i] = dp[i-1] also works since dp is initialized wuth 0
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    
    }
