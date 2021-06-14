//DFS
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 1, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int dir, int level){
        if (root==null) return;
        if (res.size()==level){
            res.add(new ArrayList<>());            
        }
        if (dir>0) res.get(level).add(root.val);
        else res.get(level).add(0, root.val);
        helper(root.left, res, dir*(-1), level+1);
        helper(root.right, res, dir*(-1), level+1);
    }

//BFS
List<List<Integer>> res = new ArrayList<>();
if (root == null) return res;
Queue<TreeNode> queue = new LinkedList<>();
queue.add(root);
boolean zigzag = false;
while (!queue.isEmpty()) {
    List<Integer> level = new ArrayList<>();
    int cnt = queue.size();
    for (int i = 0; i < cnt; i++) {
        TreeNode node = queue.poll();
        if (zigzag) {
            level.add(0, node.val);
        }
        else {
            level.add(node.val);
        }
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
    res.add(level);
    zigzag = !zigzag;
}
return res;
