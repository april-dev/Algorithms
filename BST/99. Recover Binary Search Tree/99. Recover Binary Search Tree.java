//This question requires space O(1). however the solution below is O(logN).
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        traverse(root.left);
        if (first==null && prev!=null && prev.val>root.val){
            first = prev;
        }
        if (first!=null && prev!=null && prev.val>root.val){
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}

//Solution 2 Morris Traversal (Space is O(1))
// See https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer
