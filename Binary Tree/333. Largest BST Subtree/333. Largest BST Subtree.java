/*When node==null we return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; since when one node is null, 
every parent node still can form a BST ((node.val > left[1] && node.val < right[0] this condition can be satisfied later on)

However, when a current subtree is not valid BST (else part) then we return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])}; 
since no parent subtree can be BST if one child subtree is not valid BST. By setting like that this condition node.val > left[1] && node.val < right[0] will never be 
satisfied later on
*/
public class Solution {
    
    // return array for each node: 
    //     [0] --> min
    //     [1] --> max
    //     [2] --> largest BST in its subtree(inclusive)
    
    public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }
    
    private int[] largestBST(TreeNode node){
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if(node.val > left[1] && node.val < right[0]){
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}

public class Solution {
    class Result {
        int res;
        int min;
        int max;
        public Result(int res, int min, int max) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        Result res = BSTSubstree(root);
        return Math.abs(res.res);
    }
    
    private Result BSTSubstree(TreeNode root) {
        if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = BSTSubstree(root.left);
        Result right = BSTSubstree(root.right);
        if (left.res < 0 || right.res < 0 || root.val < left.max || root.val > right.min) {
            return new Result(Math.max(Math.abs(left.res), Math.abs(right.res)) * -1, 0, 0);
        } else {
            return new Result(left.res + right.res + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
    }
}
