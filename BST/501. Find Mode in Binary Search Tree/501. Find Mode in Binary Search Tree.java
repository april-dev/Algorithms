//this may not be an O(1)-space solution for cases like 1, 2, 3, 4, 5, 6, 7, 8, ..., n - 1, n, n
//Solution 2 uses two passes to achieve space O(1). One to find the highest number of occurrences of any value, and then a second pass to collect all values occurring that often
class Solution {   
    int maxCount = 0;
    int count = 0;
    TreeNode  prev = null;
    
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        helper(root, modes);
        
        int[] res = new int[modes.size()];
        for (int i=0; i<res.length; i++) res[i] = modes.get(i);
        return res;
    }
    public void helper(TreeNode root, List<Integer> modes){
        if (root==null) return;
        helper(root.left, modes);
        
        if (prev==null){
            count = 1;
        }else{
            if (prev.val == root.val) count++;
            else count = 1;
        }
        
        if (count>maxCount){
            maxCount = count;
            modes.clear();
            modes.add(root.val);
        }else if (count==maxCount){
            modes.add(root.val);
        }
            
        prev = root;
        
        helper(root.right, modes);
    }
}

//Solution 2
public class Solution {
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    
    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}
