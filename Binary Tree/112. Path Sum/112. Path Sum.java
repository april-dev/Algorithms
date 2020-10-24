public boolean hasPathSum(TreeNode root, int sum){
        if (root==null) return false;
        if (root.left==null && root.right==null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


//Iterative
public boolean hasPathSum(TreeNode root, int sum){
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        if (root==null) return false;
        
        stackNode.push(root);
        stackSum.push(sum);
        
        while(!stackNode.isEmpty()){
            TreeNode curNode = stackNode.pop();
            int curSum = stackSum.pop();
            
            if (curNode.left==null && curNode.right==null && curNode.val==curSum) return true;
            
            if (curNode.left!=null){
                stackNode.push(curNode.left);
                stackSum.push(curSum - curNode.val);
            }
            if (curNode.right!=null){
                stackNode.push(curNode.right);
                stackSum.push(curSum - curNode.val);
            }
        }
        return false;
    }
