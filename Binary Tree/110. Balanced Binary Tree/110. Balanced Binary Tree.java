//Time: O(nlogn), worst case O(N^2) for spindly tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    //Q104. Maximum Depth of Binary Tree
    public int depth(TreeNode root){
        if (root==null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
