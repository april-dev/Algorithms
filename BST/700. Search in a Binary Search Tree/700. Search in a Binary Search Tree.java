//My solution
public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (val<root.val) return searchBST(root.left, val);
        else if (val>root.val) return searchBST(root.right, val);
        else return root;
    }


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return root;
        if (root.val == val) return root;
        return val>root.val? searchBST(root.right, val):searchBST(root.left, val);
    }
}


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {   
        while (root!=null){
            if (root.val==val) {
                return root;
            }else if (root.val>val){
                root = root.left;
            }else{
                root = root.right;
            }           
        }
        return null;
    }
}
