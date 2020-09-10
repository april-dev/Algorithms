//O(NlogN + NL^2)
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


//recursive + memo
//O(N + NL^2), dont need to sort 
class Solution {
    public int longestStrChain(String[] words) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) set.add(word);
        for(String word : words) ans = Math.max(ans, helper(map, set, word));
        return ans;
    }
    
    private int helper(Map<String, Integer> map, Set<String> set, String word){
        if(map.containsKey(word)) return map.get(word);
        int cnt = 0;
        for(int i = 0; i < word.length(); i++){
            String next = word.substring(0, i) + word.substring(i+1);
            if(set.contains(next)){
                cnt = Math.max(cnt, helper(map, set, next));
            }
        }
        map.put(word, 1 + cnt);
        return 1 + cnt;
    }
}
