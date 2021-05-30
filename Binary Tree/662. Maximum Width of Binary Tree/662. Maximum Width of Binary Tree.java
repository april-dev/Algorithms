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


class Solution {
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        List<Integer> leftMost = new ArrayList<>();
        helper(root, 0, 1, leftMost);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> leftMost){
        if (root==null) return;
        if (level==leftMost.size()) leftMost.add(index);
        max = Math.max(max, index-leftMost.get(level)+1);
        helper(root.left, level+1, 2*index, leftMost);
        helper(root.right, level+1, 2*index+1, leftMost);
    }
}
