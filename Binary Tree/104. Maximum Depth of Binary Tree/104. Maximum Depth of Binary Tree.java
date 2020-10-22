//My solution, not concise:(
class Solution {
    int maxLevel = 0;
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        helper(root, 1);
        return maxLevel;
    }
    public void helper(TreeNode root, int level){
        if (root==null) return;
        if (root.left==null && root.right==null) {
            if (level> maxLevel){
                maxLevel = level;
            }
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}


public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}


//Iterative (DFS)
public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int maxDepth = 0;
        nodeStack.push(root);
        depthStack.push(1);
        while (!nodeStack.isEmpty()){
            TreeNode cur = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (cur.left!=null) {
                nodeStack.push(cur.left);
                depthStack.push(depth+1);
            }
            if (cur.right!=null) {
                nodeStack.push(cur.right);
                depthStack.push(depth+1);
            }
        }
        return maxDepth;
    }
