class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode root, int curSum){
        if (root==null) return;
        curSum = curSum*10 + root.val;
        if (root.left==null && root.right == null){
            res+=curSum;
            return;
        }       
        helper(root.left, curSum);
        helper(root.right, curSum);
    }
}

//without global variable
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int curSum){
        if (root==null) return 0;
        
        curSum = curSum*10 + root.val;
        if (root.left==null && root.right == null) return curSum; 
        
        return helper(root.left, curSum) + helper(root.right, curSum);
    }
}

