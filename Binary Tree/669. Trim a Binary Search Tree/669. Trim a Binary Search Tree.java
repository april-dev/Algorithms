//my solution
public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null) return null;
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val<low) {
            if (root.right!=null) root = root.right;
            else root = null;
        }
        else if (root.val>high) {
            if (root.left!=null) root = root.left;
            else root = null;
        }
        return root;
    }
    
//More concise post-order traversal
public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null) return null;    
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        if (root.val<low) return root.right;
        if (root.val>high) return root.left;  
        
        return root;
 }



//preorder traversal(?)
 public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null) return null;
        /*
        //Wrong because root.right might contain invalid number, need to use recursion to go down this subtree
        //example: [3,1,4,null,2], low:3, high:4
        if (root.val<low) return root.right;
        if (root.val>high) return root.left;
        */
        if (root.val<low) return trimBST(root.right, low, high);
        if (root.val>high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
  }
  
  
  
  
  
