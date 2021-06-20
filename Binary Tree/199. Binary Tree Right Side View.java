//my solution 
//from left
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    public void helper(TreeNode root, int level, List<Integer> res){
        if (root==null) return;
        if (level==res.size()) res.add(root.val);
        res.set(level, root.val);
        helper(root.left, level+1, res);
        helper(root.right, level+1, res);
    }
}

//other solution 
//from right
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    public void helper(TreeNode root, int level, List<Integer> res){
        if (root==null) return;
        if (level==res.size()) res.add(root.val);
        helper(root.right, level+1, res);
        helper(root.left, level+1, res);
    }
}

//BFS from right to left
public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if (i==0) res.add(cur.val);
                if (cur.right!=null) q.add(cur.right);
                if (cur.left!=null) q.add(cur.left);
            }
        }
        return res;
    }
    
//BFS from left to right
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if (i==size-1) res.add(cur.val);
                if (cur.left!=null) q.add(cur.left);
                if (cur.right!=null) q.add(cur.right);
                
            }
        }
        return res;
    }
