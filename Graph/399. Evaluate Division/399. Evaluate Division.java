 public double[] calcEquation(String[][] eq, double[] vals, String[][] q) {
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            m.putIfAbsent(eq[i][0], new HashMap<>());
            m.putIfAbsent(eq[i][1], new HashMap<>());
            m.get(eq[i][0]).put(eq[i][1], vals[i]);
            m.get(eq[i][1]).put(eq[i][0], 1 / vals[i]);
        }
        double[] r = new double[q.length];
        for (int i = 0; i < q.length; i++)
            r[i] = dfs(q[i][0], q[i][1], 1, m, new HashSet<>());
        return r;
    }

    double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        if (!m.containsKey(s) || !seen.add(s)) return -1;
        if (s.equals(t)) return r;
        Map<String, Double> next = m.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), m, seen);
            if (result != -1) return result;
        }
        return -1;
    }
    
    
//DFS2
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i=0; i<equations.size(); i++){
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            double value = values[i];
            map.putIfAbsent(first, new HashMap<>());
            map.putIfAbsent(second, new HashMap<>());
            map.get(first).put(second, value);
            map.get(second).put(first, 1/value);
        }
     
        double[] res = new double[queries.size()];
        for (int i=0; i<queries.size(); i++){
            res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
     
        return res;
    }
    public double dfs(Map<String, Map<String, Double>> map, String start, String end, HashSet<String> visited){
        if (!map.containsKey(start)) return -1;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
     
        visited.add(start);
     
        for (Map.Entry<String, Double> neighbor : map.get(start).entrySet()){
            if (visited.contains(neighbor.getKey())) continue;
         
            double value =  dfs(map, neighbor.getKey(), end, visited);
            if (value!=-1) return value*neighbor.getValue();
        }
        return -1;
    }
}
