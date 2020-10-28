//Iterative
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (root.val<p.val && root.val<q.val){
                root = root.right;
            }else if (root.val>p.val && root.val>q.val){
                root = root.left;
            }else{
                break;
            }
        }
        return root;
    }
    
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
