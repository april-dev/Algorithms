//Check left and right children have the same value as parent.
public boolean isUnivalTree(TreeNode root) {
        if (root==null) return true;
        if (root.left!=null && root.val !=root.left.val) return false;
        if (root.right!=null && root.val !=root.right.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
}

//Check all nodes have the same value as root.
//v1
class Solution {
    int val = -1;
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) return true;
        if (val<0) val = root.val;
        return root.val == val && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}

//Check all nodes have the same value as root.
//v2
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);      
    }
    public boolean helper(TreeNode root, int val){
        if (root==null) return true;
        if (root.val!=val) return false;
        return helper(root.left, val) && helper(root.right, val);
    }
}
