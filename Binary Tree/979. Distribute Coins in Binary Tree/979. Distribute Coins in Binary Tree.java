class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }
    public int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        moves += Math.abs(left) + Math.abs(right);
        
        if (root.val >= 1) return left + right + root.val - 1;
        else return left + right - 1;
    }
}
