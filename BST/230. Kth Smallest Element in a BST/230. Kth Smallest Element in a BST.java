 private static int number = 0;
  private static int count = 0;

  public int kthSmallest(TreeNode root, int k) {
      count = k;
      helper(root);
      return number;
  }
  
  public void helper(TreeNode n) {
      if (n.left != null) helper(n.left);
      count--;
      if (count == 0) {
          number = n.val;
          return;
      }
      if (n.right != null) helper(n.right);
  }
  
 
public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<>();
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);    
             root = root.left;   
         } 
         root = stack.pop();
         if(--k == 0) break;
         root = root.right;
     }
     return root.val;
 }
