public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        helper(kill, map, res);
        return res;
    }
    void helper(int kill, Map<Integer, List<Integer>> map, List<Integer> res) {
        res.add(kill);
        if (map.containsKey(kill)) {
            for (int k : map.get(kill)) {
                helper(k, map, res);
            }
        }
    }
