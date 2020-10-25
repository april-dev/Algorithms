/*
Also using ArrayList allows O(1) access to the each node, that means removing the last element takes only O(1). 
If you use LinkedList, initially we have traverse the list to the last node then remove it, which takes O(n) time. 
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp =  new ArrayList<>();
        helper(root, sum, temp, res);
        return res;
    }
    public void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res){
        if (root==null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){   
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }        
        helper(root.left, sum-root.val, temp, res);
        helper(root.right, sum-root.val, temp, res);
        temp.remove(temp.size()-1);
    }
}
