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

//without global variable
public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }


// Time: O(nlogn) for balanced tree, O(n^2) for worst case when tree is like linked list
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int pathSumFrom(TreeNode root, int sum){
        if (root==null) return 0;
       return (root.val==sum? 1:0 ) + pathSumFrom(root.left, sum - root.val) +   pathSumFrom(root.right, sum - root.val);    
    }
}
