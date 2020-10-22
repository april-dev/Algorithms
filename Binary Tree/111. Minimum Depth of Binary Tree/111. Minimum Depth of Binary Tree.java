public static int minDepth(TreeNode root) {
	    if (root == null)	return 0;
	    if (root.left==null) return minDepth(root.right) + 1;
        if (root.right==null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    
public static int minDepth(TreeNode root) {
	    if (root == null)	return 0;
	    int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left==0 || right==0) return Math.max(left, right) + 1;
        else return Math.min(left, right) + 1;
}

//BFS
public static int minDepth(TreeNode root) {
        if (root==null) return 0;
	    Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode cur = queue.poll();
                if (cur.left==null && cur.right==null) return level;
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
            }
            level++;
        }
        return level;
    }
