public int longestStrChain(String[] words) {
        
        HashMap<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        
        int res=0;
        for (String word:words){
            int best=0;
            for (int i=0; i<word.length(); i++){
                String s_prev = word.substring(0,i)+word.substring(i+1);
                best = Math.max(best,dp.getOrDefault(s_prev,0)+1);
            }
            dp.put(word, best);
            res= Math.max(res, best);
        }
        return res;
    }
