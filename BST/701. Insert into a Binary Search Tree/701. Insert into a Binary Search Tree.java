class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
       if (root==null) return new TreeNode(val, null, null);
       if (root.val>val) root.left = insertIntoBST(root.left, val);
       if (root.val<val) root.right = insertIntoBST(root.right, val);        
       return root;
    }
}


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur!=null){
            prev = cur;
            if (cur.val>val) {
                cur = cur.left;
            }else if (cur.val<val) {
                cur = cur.right;
            }
        }
        if (val>prev.val) prev.right = new TreeNode(val, null, null);
        if (val<prev.val) prev.left = new TreeNode(val, null, null);
        return root;
    }
}


public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        while(true) {
            if(cur.val <= val) {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
