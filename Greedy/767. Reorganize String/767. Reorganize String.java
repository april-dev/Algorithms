public String reorganizeString(String S) {
        int[] map = new int[26];
        int max = 0, largest=0;
        for (char c:S.toCharArray()){
            map[c-'a']+=1;
        }
        for (int i=0; i<map.length; i++){
            if (map[i]>max){
                max= map[i];
                largest = i;
            }
        }
        int empty = max-1;
        int available = S.length()-max;
        if (available<empty) return "";
        char[] res = new char[S.length()];
        int idx=0;
        while (map[largest]>0){
            res[idx] = (char) (largest+'a');
            idx+=2;
            map[largest]-=1;
        }
        for (int i=0; i<map.length; i++){
            while (map[i]>0){
                if (idx>=res.length){
                    idx=1;
                }
                res[idx] = (char) (i+'a');
                idx+=2;
                map[i]-=1;
            }
        }
        return String.valueOf(res);
        
    }
