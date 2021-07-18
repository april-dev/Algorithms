
//with global variable
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    public void helper(TreeNode root, int max){
        if (root==null) return ;
        if (root.val>=max) count++;
        max = Math.max(max, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }
}


//without global variable
class Solution {
   // int count = 0;
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
        //return count;
    }
    public int helper(TreeNode root, int max){
        if (root==null) return 0;
        int count = 0;
        if (root.val>=max) count++;
        max = Math.max(max, root.val);
        count += helper(root.left, max);
        count+= helper(root.right, max);
        return count;
    }
}
