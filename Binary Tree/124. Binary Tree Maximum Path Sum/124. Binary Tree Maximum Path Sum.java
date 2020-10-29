/*
max is the value which records whether this current root is the final root with max path sum, so we use left + right + node.val. But to the upper layer(after return statement), 
we cannot choose both left and right branches, so we need to select the larger one, so we use max(left, right) + node.val to prune the lower branch.
*/

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    public int maxGain(TreeNode root){
        if (root==null) return 0;
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
