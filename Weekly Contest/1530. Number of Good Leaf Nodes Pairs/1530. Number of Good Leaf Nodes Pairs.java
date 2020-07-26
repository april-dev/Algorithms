//arr[i]: the number of leaf nodes, i: distance to current node is i.

private int res = 0, dist = 0;
    
    public int countPairs(TreeNode root, int distance) {
        dist = distance;
        helper(root);
        return res;
    }
    
    private int[] helper(TreeNode n) {
        int[] arr = new int[dist + 1];
        if(n == null)
            return arr;
        if(n.left == null && n.right == null) {
            arr[1] = 1;
            return arr;
        }
        int[] left = helper(n.left);
        int[] right = helper(n.right);
        
        for(int i = 1; i < dist; i++) {
            for(int j = 1; j < dist; j++) {
                if(i + j <= dist)
                    res += (left[i] * right[j]);
            }
        }
        
        for(int i = dist; i > 0; i--) 
            arr[i] += (left[i - 1] + right[i - 1]);
        return arr;
    }
    
    //second method
        int res=0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }
    public int[] dfs(TreeNode root, int distance){
        if (root== null) return new int[0];
        if (root.left==null && root.right==null) return new int[]{1};
        int[] left = dfs(root.left, distance), right = dfs(root.right, distance);
        for (int l: left)
            for (int r: right)
                if (l+r<=distance) res++;
        int idx=0;
        int[] cur = new int[left.length+right.length];
        for (int l: left) cur[idx++]=l+1;
        for (int r: right) cur[idx++]=r+1;
        return cur;
    }
