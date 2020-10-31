//failed for test case [2147483647]
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int min, int max){
        if (root==null) return true;
        if (root.val<=min || root.val>=max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

//We can use Object Integer and null pointer to avoid the corner cases (when node has value Integer.MIN_VALUE or Integer.MAX_VALUE ).
public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) return false;
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }


//Iterative solution

/*
Inorder traversal
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.empty()){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root.right;
        
    }
    return list;
}

*/
public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}
