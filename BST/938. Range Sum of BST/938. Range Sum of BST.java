public int rangeSumBST(TreeNode root, int L, int R){   
        if (root==null) return 0;
        if (root.val<L) return rangeSumBST(root.right, L, R);
        else if (root.val>R) return rangeSumBST(root.left, L, R);
        
        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        
        return left+ right+root.val;
    }
    
 public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur == null) continue; 
            if (cur.val>L) stack.push(cur.left);
            if (cur.val<R) stack.push(cur.right);
            if (cur.val>=L && cur.val<=R) sum+=cur.val;
        }
        return sum;
    }
