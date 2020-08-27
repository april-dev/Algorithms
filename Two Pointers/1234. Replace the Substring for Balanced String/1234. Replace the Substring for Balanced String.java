public int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length(), res = n, i = 0, k = n / 4;
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j)];
        }
        for (int j = 0; j < n; ++j) {
            --count[s.charAt(j)];
            while (i < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                res = Math.min(res, j - i + 1);
                ++count[s.charAt(i++)];
            }
        }
        return res;
    }
    
    //reduced the problem to finding a minimum substring containing a certain number of each character.
    //https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/409017/JAVA-Sliding-Window-Solution-with-Explanation
    class Solution {
	// Checks that freq[char] <= 0 meaning we have an elligible substring
    private boolean fulfilled(int[] freq) {
        boolean fulfilled = true;
        for(int f: freq) {
            if(f > 0) fulfilled = false;
        }
        return fulfilled;
    }
    
	 // Q 0 W 1 E 2 R 3
    private int charToIdx(char c) {
        switch(c) {
            case 'Q': return 0;
            case 'W': return 1;
            case 'E': return 2;
        }
        return 3;
    }
    
    public int balancedString(String s) {
        // 1) Find freq of each first
        int N = s.length();
        int required = N/4;
       
        int[] freq = new int[4];
        for(int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            ++freq[charToIdx(c)];
        }
        
        // 2) Determine the ones we need to change
        boolean equal = true;
        for(int i = 0; i < 4; ++i) {
            if(freq[i] != required) equal = false;
            freq[i] = Math.max(0, freq[i] - required);
        }
        
        if(equal) return 0; // Early return if all are equal
        
        // 3) Use sliding window and try to track what more is needed to find smallest window
        int start = 0;
        int minLen = N; // Maximum will only ever be N
        
        for(int end = 0; end < N; ++end) {
            char c = s.charAt(end);
            --freq[charToIdx(c)];
            
            while(fulfilled(freq)) {
                minLen = Math.min(end - start + 1, minLen);

                char st = s.charAt(start);
                ++freq[charToIdx(st)];
                ++start;
            }
        }
        
        return minLen;
    }
}
