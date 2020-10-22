//Multiple pass, Time: O(nlogn), worst case O(N^2) for spindly tree
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


//One pass, time: O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        if (left==-1) return -1;
        int right = helper(root.right);
        if (right==-1) return -1;
        
        if (Math.abs(left-right)>1) return -1;
        
        return Math.max(left, right) + 1;
    }
}

//Alternatives, but much slower if the tree is heavily skewed right
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode root){
        if (root==null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
               
        if (left==-1 || right==-1 || Math.abs(left-right)>1) return -1;
        
        return Math.max(left, right) + 1;
    }
}
