
public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                /*
                if input="abbabc"
                when i = 3, s.chatAt(3) == 'a' , we will found last 'a' appears at index 0,
                but we should not update j from 2 ('b') to 0 ('a'), because here although the 'a' is in hashMap, but it appears before 'b'.              
                */
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    
    //two pointers
    public int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> map =  new HashMap<>();
        int i=0, len = 0;
        for (int j=0; j<s.length(); j++){
            int idx = s.charAt(j)-'a';
            map.put(idx, map.getOrDefault(idx, 0)+1);
            while (map.get(idx)>1){
                map.put(s.charAt(i)-'a', map.get(s.charAt(i)-'a')-1);
                i++;
            }
            len = Math.max(j-i+1, len);
        }
        return len;
    }
