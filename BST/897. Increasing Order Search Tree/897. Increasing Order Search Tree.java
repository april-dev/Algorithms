//my solution
class Solution {
    TreeNode head;
    TreeNode dummy;
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode(0);
        dummy = head;
        helper(root);
        return dummy.right;
    }
    public void helper(TreeNode root){
        if (root==null) return;
        helper(root.left);
        head.right = new TreeNode(root.val);
        head = head.right;
        helper(root.right);
    }
}

//solution from Leetcode
class Solution {
    private TreeNode result;
    private TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (result == null) {
            result = root;
        } else {
            pre.right = root;
        }
        pre = root;
        root.left = null;
        inorder(root.right);
    }
}
