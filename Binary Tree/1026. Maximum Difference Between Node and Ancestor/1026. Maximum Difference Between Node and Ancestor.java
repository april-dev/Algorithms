class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return res;
    }
    public void helper(TreeNode root, int min, int max){
        if (root==null) return;
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        res = Math.max(res, max-min);
        helper(root.left, min, max);
        helper(root.right, min, max);
    }    
}
