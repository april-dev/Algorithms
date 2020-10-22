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



//BFS
class Solution {
    int min =0, max=0;
    public class Pair {
        int x;
        int y;
        TreeNode n;
        
        Pair(TreeNode n, int x, int y){
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> Q = new LinkedList<>();
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
             
        Q.add(new Pair(root,0,0));
        int min=0, max = 0;
        while (!Q.isEmpty()){
            Pair cur = Q.remove();
            
            min = Math.min(min, cur.x);
            max = Math.max(max, cur.x);
                        
            if (!map.containsKey(cur.x))
                map.put(cur.x, new ArrayList<Pair>());
            
            map.get(cur.x).add(cur);
            
            if (cur.n.left != null) Q.add(new Pair(cur.n.left,cur.x-1, cur.y-1 ));
            if (cur.n.right != null) Q.add(new Pair(cur.n.right,cur.x+1, cur.y-1 )); 
        }
        
        for (int i=min; i<=max; i++){
            List<Pair> list = map.get(i);
             
            Collections.sort(list, new Comparator<Pair>(){
                @Override
                public int compare(Pair a, Pair b){
                    if (a.y == b.y) {
                        return a.n.val - b.n.val;
                    }
                    return 0;
                }
            });
            
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<list.size(); j++){
                temp.add(list.get(j).n.val);
            }
            res.add(temp);      
        }
        return res;
    }  
}            
