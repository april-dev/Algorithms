/*
without memorization, TLE for case
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

*/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict, map);
    }
    public List<String> dfs(String s, Set<String> wordDict, HashMap<String, List<String>> map){       
        if (map.containsKey(s)) return map.get(s);
        
        List<String> ret = new ArrayList<>();
        if (wordDict.contains(s)) ret.add(s);
    
        for (int i=1; i<=s.length(); i++){
            String right = s.substring(i);
            if (!wordDict.contains(right)) continue;
            
            String left = s.substring(0, i);
            List<String> listLeft = dfs(left, wordDict, map);
            for (String cur:listLeft){
                ret.add(cur + " " + right);
            }
        }
        map.put(s, ret);
        return ret;
    }
}
