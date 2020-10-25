class Solution {
 int res = 0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> presum = new HashMap<>();
        presum.put(0, 1);
        helper(root, 0, sum, presum);
        return res;
    }
    public void helper(TreeNode root, int curSum, int target, HashMap<Integer, Integer> presum){
        if (root==null) return;
        curSum += root.val;
        if (presum.containsKey(curSum - target)) res += presum.get(curSum - target);
        presum.put(curSum, presum.getOrDefault(curSum, 0)+1);
        
        helper(root.left, curSum, target, presum);
        helper(root.right, curSum, target, presum);
        presum.put(curSum, presum.get(curSum)-1);
        
    }
}
