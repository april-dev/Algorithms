//DFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int level){
        if (root==null) return;
        if (level>=res.size()) res.add(0, new ArrayList<>());
        res.get(res.size()-level-1).add(root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);        
    }
}

//BFS
