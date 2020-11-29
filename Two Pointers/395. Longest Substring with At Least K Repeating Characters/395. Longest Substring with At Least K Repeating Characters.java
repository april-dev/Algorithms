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
