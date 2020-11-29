public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int i, j, noLessThanK, unique;
        int res = 0;
        for (int h=1; h<=26; h++){
            Arrays.fill(count, 0);
            i=0;
            j=0;
            noLessThanK = 0;
            unique = 0;
            while (j < str.length){
                if (unique <= h){
                    int index = str[j] - 'a';
                    if (count[index]==0) unique++;
                    count[index]++;
                    if (count[index]==k) noLessThanK++;
                    j++;
                }else{
                    int index = str[i] - 'a';
                    count[index]--;
                    if (count[index] == 0) unique--;
                    if (count[index] == k-1) noLessThanK--;
                    i++;
                }
                if (unique==noLessThanK) res = Math.max(j-i, res);
            }
        }
        return res;
    }

//divide and conquer (recursion)
public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
