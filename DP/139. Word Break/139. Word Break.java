//dp[i] stands for whether subarray(0, i) can be segmented into words from the dictionary. So dp[0] means whether subarray(0, 0) (which is an empty string) can be segmented, 
//and of course the answer is yes.

//The default value for boolean array is false. Therefore we need to set dp[0] to be true.


public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if(dp[j]==true && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
