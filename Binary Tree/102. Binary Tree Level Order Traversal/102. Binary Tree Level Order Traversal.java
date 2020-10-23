//BFS
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-->0){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
            }
            res.add(temp);
        }
        return res;
    }
    
    //DFS
    class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if (root==null) return;
        if (level>=res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
}
