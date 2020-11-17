class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordList);
        buildMap(beginWord, endWord, dict, map);
        dfs(beginWord, endWord, map, path, res);
        return res;
    }
    public void buildMap(String begin, String end, HashSet<String> dict, HashMap<String, List<String>> map){
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> toVisit = new HashSet<>();
        queue.add(begin);
        toVisit.add(begin);
        boolean foundEnd = false;
        
        while (!queue.isEmpty()){
            visited.addAll(toVisit);
            toVisit.clear();
            int size = queue.size();
            while (size-->0){
                String cur = queue.poll();
                List<String> children = getNextLevel(cur, dict);
                for (String child:children){
                    if (child.equals(end)) foundEnd = true;
                    if (!visited.contains(child)){
                        if (!map.containsKey(cur)) map.put(cur, new ArrayList<>());
                        map.get(cur).add(child);
                    }
                    if (!visited.contains(child) && !toVisit.contains(child)){
                        queue.add(child);
                        toVisit.add(child);
                    }
                }                
            }
            if (foundEnd) break;            
        }
    }
    
    public List<String> getNextLevel(String cur, HashSet<String> dict){
        List<String> res = new ArrayList<>();
        char[] arr = cur.toCharArray();
        for (int i=0; i<arr.length; i++){
            for (char c = 'a'; c<='z'; c++){
                if (arr[i]==c) continue;
                char temp = arr[i];
                arr[i] = c;
                String target = String.valueOf(arr);
                if (dict.contains(target)) res.add(target);
                arr[i] = temp;
            }
        }
        return res;
    }
    
    public void dfs(String curWord, String endWord, HashMap<String, List<String>> map, List<String> path, List<List<String>> res){
        path.add(curWord);       
        if (curWord.equals(endWord)) res.add(new ArrayList<String>(path));
        else if (map.containsKey(curWord)) {
            for (String nextWord : map.get(curWord)) {
                dfs(nextWord, endWord, map, path, res);
            }
        }
        path.remove(path.size()-1);
        
    }
}
