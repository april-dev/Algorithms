//Solution 1 is not efficient since it copy the value. assigning node is a better approach. Solution 2 increase tree height. Solution 3 and 4 is more height balanced.

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;
        if (key<root.val) {
            root.left = deleteNode(root.left, key);
        }else if (key>root.val){
            root.right = deleteNode(root.right, key);
        }else{
           if (root.left==null) return root.right;
           if (root.right==null) return root.left;
        
           TreeNode minNode = findMin(root.right);
           int min = minNode.val;
           root.val= min;
           root.right = deleteNode(root.right, min);
        }  
        return root;
    }
    public TreeNode findMin(TreeNode node){
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }   
}

//Solution 2 
//this solution may potentially increase the height of the tree.
public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) rightSmallest = rightSmallest.left;
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }

//Solution 3
public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode newRoot = root.right, par = null;
                while(newRoot.left != null){
                    par = newRoot;
                    newRoot = newRoot.left;
                }
                if(par == null){
                    newRoot.left = root.left;
                    return newRoot;
                }
                par.left = newRoot.right;
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        return root;
    }
    
    //Solution 4
   //Iterative way
    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        for(; next.left != null; pre = next, next = next.left);
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }
