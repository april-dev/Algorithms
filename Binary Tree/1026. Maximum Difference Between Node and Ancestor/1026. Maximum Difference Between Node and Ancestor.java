//Top down to track max and min so far
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

//Without global variable
public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
