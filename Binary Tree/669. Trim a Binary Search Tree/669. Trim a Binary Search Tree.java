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

//Iterative
public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null) return null; 
        //Find a valid root which is used to return.
        while (root.val<low || root.val>high){
            if (root.val<low) root = root.right;
            if (root.val>high) root = root.left;
        }
        TreeNode dummy = root;
        // Remove the invalid nodes from left subtree.
        while (dummy != null){
            while (dummy.left != null && dummy.left.val<low){
                dummy.left = dummy.left.right;
            }
            dummy = dummy.left;//dummy.right does not need to be checked because these nodes are on the left side of root, so their upper value is bounded by root.val 
                               //root.val is guaranteed to be valid from the previous step
        }
        dummy = root;
       // Remove the invalid nodes from right subtree
         while (dummy != null){
            while (dummy.right != null && dummy.right.val>high){
                dummy.right = dummy.right.left;
            }
            dummy = dummy.right;
        }
        return root;
    }
  
  
  
  
  
