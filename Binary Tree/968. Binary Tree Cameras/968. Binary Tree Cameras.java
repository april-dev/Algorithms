class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        int rootStatus = helper(root);
        if (rootStatus==0) res++;
        return res;
        
    }
    //2: it is covered, without a camera on this node
    //1: a camera is on this node
    //0: not covered
    public int helper(TreeNode root){
        if (root==null) return 2;
        int left = helper(root.left);
        int right = helper(root.right);
        //first check if there a child that is not covered, if there is, then a camera must be added at this parent node.
        if (left==0 || right==0) {
            res++;
            return 1;
        }
        //now since both left and right are covered, then check if either left or right has a camera, if it is, then the parent does not need a camera
        if (left==1 || right==1){
            return 2;
        }else{//here both left and right are covered and neither of them has a camera, the parent is not covered (return 0)
            return 0;
        }
        
    }
}
