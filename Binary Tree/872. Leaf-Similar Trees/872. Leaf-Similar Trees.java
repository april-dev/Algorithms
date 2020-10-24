//StringBuilder
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        helper(root1, sb1);
        helper(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }
    public void helper(TreeNode root, StringBuilder sb){
        if (root == null) return;
        if (root.left==null && root.right==null) sb.append(root.val+"-");
        helper(root.left, sb);
        helper(root.right, sb);
    }
}

//String
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String s1 = helper(root1);
        String s2 = helper(root2);
        return s1.equals(s2);
    }
    public String helper(TreeNode root){
        if (root == null) return "";
        if (root.left==null && root.right==null) return root.val+"-";
        return helper(root.left) + helper(root.right);
    }
}

//Stack
//O(H) space,where H is the height of the tree.
//faster because early exit
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()){
        //early exit
            if (dfs(stack1)!=dfs(stack2)) return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int dfs(Stack<TreeNode> stack){
        while (true){
            TreeNode cur = stack.pop();
            if (cur.left==null && cur.right==null) return cur.val;
            if (cur.left!=null) stack.push(cur.left);
            if (cur.right!=null) stack.push(cur.right);
        }
    }
}
