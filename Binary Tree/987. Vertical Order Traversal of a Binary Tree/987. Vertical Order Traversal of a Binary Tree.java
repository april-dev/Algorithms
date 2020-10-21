//TreeMap
class Solution {  
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(root, 0, 0, map);
        for (TreeMap<Integer, PriorityQueue<Integer>> ys:map.values()){
           res.add(new ArrayList<>());
            for (PriorityQueue<Integer> node: ys.values()){
                while (!node.isEmpty()){
                    res.get(res.size()-1).add(node.poll());
                }
            }          
        }
        return res;
    }
    public void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if (root==null) return;
        if (!map.containsKey(x)) map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x-1, y+1, map);
        dfs(root.right, x+1, y+1, map);        
    }
}

