class Solution {
    int minDiff = Integer.MAX_VALUE;
    Integer pre = null;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDiff;
    }
    public void helper(TreeNode root){
        if (root.left!=null) helper(root.left);
        if (pre!=null) minDiff = Math.min(minDiff, root.val-pre);
        pre = root.val;
        if (root.right!=null) helper(root.right);
    }
}

//Solution 2
public class Solution {
    
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }

}

//Solution 3 (without global variable)
public int getMinimumDifference(TreeNode root) {
    	List<Integer> prev = new ArrayList<>(); // contains at most 1 value
    	int[] min = new int[]{Integer.MAX_VALUE};
    	inorder(root, prev, min);
    	return min[0];
    }
    
    private void inorder(TreeNode root, List<Integer> prev, int[] min) {
    	if (root == null) return;
    	
    	inorder(root.left, prev, min);
    	if (prev.isEmpty()) {
    		prev.add(root.val);
    	} else {
    		min[0] = Math.min(min[0], Math.abs(root.val - prev.get(0)));
    		prev.set(0, root.val);
    	}
    	inorder(root.right, prev, min);    	
    }
    
    //Solution 4
    public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
    
}
