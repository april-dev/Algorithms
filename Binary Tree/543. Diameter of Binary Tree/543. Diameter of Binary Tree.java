class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return max;
    }
    public int maxDiameter(TreeNode root) {
        if (root==null) return 0;
        
        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
