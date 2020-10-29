class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        maxLength(root);
        return max;
    }
    public int maxLength(TreeNode root){
        if (root==null) return 0;
        int left = maxLength(root.left);
        int right = maxLength(root.right);
        left = root.left!=null && root.left.val==root.val? left+1 : 0;
        right = root.right!=null && root.right.val==root.val? right+1 : 0;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
