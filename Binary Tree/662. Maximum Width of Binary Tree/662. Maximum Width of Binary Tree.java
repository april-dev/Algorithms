public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root==null) return 0;
        int res = 1;
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int l = queue.peek().getValue(), r = l;
            for (int i=0; i<size; i++){
                Pair<TreeNode, Integer> cur = queue.poll();
                TreeNode node = cur.getKey();
                r = cur.getValue();
                if (node.left!=null) queue.add(new Pair(node.left, 2*r));
                if (node.right!=null) queue.add(new Pair(node.right, 2*r+1));
            }
            res = Math.max(res, r-l+1);
        }
        return res;     
    }
