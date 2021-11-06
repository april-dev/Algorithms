public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public int helper(TreeNode root, List<List<Integer>> res){
        if (root==null) return -1;
        if (root.left==null && root.right==null) {
            if (res.size()==0){
            res.add(new ArrayList<>());               
            }
            res.get(0).add(root.val);
            return 0;
        }            
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int level = Math.max(left, right)+1;
        if (res.size()==level){
            res.add(new ArrayList<>());            
        }
        res.get(level).add(root.val);
        return level;
    }

//remove redundancy
public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public int helper(TreeNode root, List<List<Integer>> res){
        if (root==null) return -1;
                  
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int level = Math.max(left, right)+1;
        if (res.size()==level) res.add(new ArrayList<>());            
        
        res.get(level).add(root.val);
        return level;
    }
