//my solution
class Solution {
    int maxlevel = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper(TreeNode root, int level){
        if (root==null) return;
        if (root.left == null && root.right==null) {
            if (level > maxlevel){
                sum = root.val;
                maxlevel = level;
                
            }else if (level==maxlevel){
                sum+=root.val;
                
            }
            return;
        }
        
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}

//concise
class Solution {
    int maxlevel = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper(TreeNode root, int level){
        if (root==null) return;
        if (level > maxlevel){
            sum = root.val;
            maxlevel = level;
        }else if (level==maxlevel){
            sum+=root.val;       
        }        
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}


//BFS
public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for (int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
            }
        }
        return sum;
    }
