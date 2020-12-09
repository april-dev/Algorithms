//my solution, not O(h) memory, h is the height of tree
//not memory efficient
class BSTIterator {
    TreeNode node;
    List<Integer> vals;
    int index;
    int num;
    public BSTIterator(TreeNode root) {
        node = new TreeNode(-1);
        vals = new ArrayList<>();
        find(root);
        index = -1;
        num = vals.size();
        
    }
    public void find(TreeNode root){
        if (root==null) return;
        find(root.left);
        vals.add(root.val);
        find(root.right);
    }
    
    public int next() {
        index++;
        num--;
        return vals.get(index);
    }
    
    public boolean hasNext() {
        if (num>0) return true;
        else return false;
    }
}


//soltion from Leetcode 
//use iterative in-order traversal
//average O(1) time, O(h) memory
/*
The average time complexity of next() function is O(1). As the next function can be called n times at most, and the number of right nodes in pushAll(tmpNode.right) function 
is maximal n in a tree which has n nodes, so the amortized time complexity is O(1).
*/
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        pushAll(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushAll(TreeNode node){
        while (node!=null){
            stack.push(node);
            node = node.left;
        }
    }
}

