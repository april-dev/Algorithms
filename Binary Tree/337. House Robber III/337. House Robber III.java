//https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem

class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    public int[] helper(TreeNode root){
        if (root==null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int[] cur = new int[2];
        //cur[0] = left[1] + right[1]; is wrong, consider the case [4,1,null,2,null,3,null]
        cur[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        cur[1] = root.val + left[0] + right[0];
        
        return cur;
    }
}
