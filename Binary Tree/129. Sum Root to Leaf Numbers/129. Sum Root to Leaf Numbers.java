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

//Iterative
public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> numStack = new Stack<>();
        nodeStack.push(root);
        numStack.push(""+root.val);
        int res = 0;
        while (!nodeStack.isEmpty()){
            TreeNode curNode = nodeStack.pop();
            String curNum = numStack.pop();
            if (curNode.left==null && curNode.right==null){
                res += Integer.valueOf(curNum);
            }
            if (curNode.left!=null){
                nodeStack.push(curNode.left);
                numStack.push(curNum + "" + curNode.left.val);
            }
            if (curNode.right!=null){
                nodeStack.push(curNode.right);
                numStack.push(curNum + "" + curNode.right.val);
            }
        }
        return res;
    }
