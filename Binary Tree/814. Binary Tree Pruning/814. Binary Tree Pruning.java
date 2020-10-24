public TreeNode pruneTree(TreeNode root) {
        if (root==null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val==0 && root.left==null && root.right==null) return null;
        return root;
    }
    
    
//Alternative
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root==null) return null;
        if (dfs(root)==0) return null;
        return root;
    }
    public int dfs(TreeNode root){
        if (root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        root.left = l==0? null: root.left;
        root.right = r==0? null: root.right;
        return l + r + root.val;
    }
}
