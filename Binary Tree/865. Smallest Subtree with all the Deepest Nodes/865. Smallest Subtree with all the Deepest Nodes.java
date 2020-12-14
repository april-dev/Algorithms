//post-order traversal
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).getValue();
    }
    public Pair<Integer, TreeNode> helper(TreeNode root){
        if (root==null) return new Pair(0, null);
        Pair<Integer, TreeNode> left = helper(root.left);
        Pair<Integer, TreeNode> right = helper(root.right);
        
        int leftHeight = left.getKey();
        int rightHeight = right.getKey();
        if (leftHeight == rightHeight) return new Pair(leftHeight+1, root);
        else if (leftHeight < rightHeight) return new Pair(rightHeight+1, right.getValue());
        else return new Pair(leftHeight+1, left.getValue());
    }
}
