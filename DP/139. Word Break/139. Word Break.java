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

//Brute force O(2^N)
/*
Given an array of length n, there are n+1 ways/intervals to partition it into two parts. Each interval has two choices - split or not. 
In the worse case, we will have to check all possibilities, which becomes O(2^(n+1)) -> O(2^n). 
*/

/*
T(N) = T(N-1) + T(N-2) + ... + T(0)
T(N-1) = T(N-2) + ... + T(0)
T(N) - T(N-1) = T(N-1)
T(N) = 2*T(N-1)
O(2^N)
*/

 public boolean wordBreak(String s, List<String> wordDict) {
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
