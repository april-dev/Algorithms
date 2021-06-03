public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int min = 0;
        int max = 0;
        while (!q.isEmpty()){
            Pair<TreeNode, Integer> cur = q.poll();
            TreeNode node = cur.getKey();
            int col = cur.getValue();
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left!=null) {
                q.add(new Pair<>(node.left, col-1));
                min = Math.min(min, col-1);
            }
            if (node.right!=null) {
                q.add(new Pair<>(node.right, col+1));
                max = Math.max(max, col+1);
            }
        }
        
        
        for (int i=min; i<=max; i++){
            res.add(map.get(i));
        }
        return res;
    }
