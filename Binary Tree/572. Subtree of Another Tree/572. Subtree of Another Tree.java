/*
Nice,
If assum m is the number of nodes in the 1st tree and n is the number of nodes in the 2nd tree, then
Time complexity: O(m*n), worst case: for each node in the 1st tree, we need to check if isSame(Node s, Node t). Total m nodes, isSame(...) takes O(n) worst case
Space complexity: O(height of 1str tree)(Or you can say: O(m) for worst case, O(logm) for average case)
*/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //Because the question says s and t are non-empty, so it is commented out
        //if (s==null && t==null) return true;
        if (s==null) return false;
        if (SameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean SameTree(TreeNode p, TreeNode q){
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val !=q.val) return false;
        return SameTree(p.left, q.left) && SameTree(p.right, q.right);
    }
}
