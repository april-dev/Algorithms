//DFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if (root==null) return;
        if (level>=res.size()) res.add(0, new LinkedList<>());
        res.get(res.size()-level-1).add(root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);        
    }
}

//BFS
public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            while (size-->0){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
            }
            res.add(0, temp);
        }
        return res;
    }
