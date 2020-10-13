class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res){
        if (root==null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}


//Based on preorder traversal
/*
Preorder:
print(node.val);
dfs(node.left);
dfs(node.right);

reversed post-order:
print(node.val);
dfs(node.right);
dfs(node.left);

*/
public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        if (root==null) return ans;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if (node.left!=null) stack.add(node.left);
            if (node.right!=null) stack.add(node.right);
        }
        return ans;
    }


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        
        while (cur!=null || !stack.isEmpty()){
            while (!isLeaf(cur)){
                stack.add(cur);
                cur = cur.left;
            }
            if (cur!=null) ans.add(cur.val);
            while (!stack.isEmpty() && cur == stack.peek().right){
                cur = stack.pop();
                ans.add(cur.val);
            }
             if (stack.isEmpty()) cur = null;
            else cur = stack.peek().right;
        }
        return ans;
    }
    public boolean isLeaf(TreeNode root){
        if (root==null) return true;
        return (root.left==null && root.right==null);
    }
}
