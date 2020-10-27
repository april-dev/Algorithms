public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
 }

//Iterative
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode cur = stack.pop();
            if (cur.left!=null){
                stack.push(cur.left);
                parent.put(cur.left, cur);
            }
            if (cur.right!=null){
                stack.push(cur.right);
                parent.put(cur.right, cur);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p = parent.get(p);
        }
        while(!set.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
