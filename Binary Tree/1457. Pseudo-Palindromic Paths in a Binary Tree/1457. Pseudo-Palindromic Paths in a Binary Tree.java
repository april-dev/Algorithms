//my solution
class Solution {
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        helper(root, count);
        return res;
    }
    public void helper(TreeNode root, int[] count){
        if (root==null) return;
        
        count[root.val]++;
        
        if (root.left==null && root.right==null){       
            int odd = 0;
            for (int i=1; i<10; i++){
                if (count[i]>0 && count[i]%2!=0)odd++;              
            }
            if (odd<=1) res++;
        }
        
        helper(root.left, count);
        helper(root.right, count);
        
        count[root.val]--;
    }    
}
