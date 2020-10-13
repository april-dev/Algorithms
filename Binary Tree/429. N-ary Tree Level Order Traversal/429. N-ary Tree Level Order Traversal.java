//BFS
public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        if (root==null) return res;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for (int i=0; i<size; i++){
                Node cur = q.poll();
                temp.add(cur.val);
                for (Node child:cur.children) q.offer(child);
            }
            res.add(temp);
        }
        return res;
    }


//DFS
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    public void helper(Node root, List<List<Integer>> res, int level){
        if (root==null) return;
        if (res.size()==level){
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
        }
        res.get(level).add(root.val);
        for (Node child:root.children){
            helper(child, res, level+1);
        }
    }
}
