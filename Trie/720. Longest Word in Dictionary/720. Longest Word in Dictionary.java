//Trie + sorting
class MagicDictionary {
    Map<String, HashSet<Character>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for (String s:dictionary){
            for (int i=0; i<s.length(); i++){
                String temp =s.substring(0, i) +"*" + s.substring(i+1);
                HashSet<Character> set = map.getOrDefault(temp, new HashSet<>());
                set.add(s.charAt(i));
                map.put(temp, set);
            }
        }
    }
    
    public boolean search(String searchWord) {
        char[] s = searchWord.toCharArray();
        for (int i=0; i<searchWord.length(); i++){
            char c = s[i];
            s[i] = '*';
            String t = new String(s);
            if (map.containsKey(t)){
                HashSet set = map.get(t);
                if (!set.contains(c) || set.size()>1) return true;
            }
            s[i] = c;
        }
        return false;
    }
}
