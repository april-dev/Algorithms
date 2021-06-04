public List<Integer> findAnagrams(String s, String p) {
        int i=0, j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int counter = map.size();
        int len = 0;
        List<Integer> res  = new ArrayList<>();
        while (j<s.length()){
            char c = s.charAt(j);
            if (map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if (map.get(c)==0) counter--;
            }
            j++;
            while (counter==0){
                char tempc = s.charAt(i);
                if (map.containsKey(tempc)){
                    if (map.get(tempc)==0) counter++;
                    map.put(tempc,map.get(tempc)+1);
                }
                if (j-i==p.length()){
                    res.add(i);
                }
                i++;
            }
        }
        return res;
    }
