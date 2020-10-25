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



//Iterative
public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        List<Integer> temp =  new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        int pathSum = 0;
        TreeNode prev = null, cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                temp.add(cur.val);
                pathSum += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev){
                cur = cur.right;
                continue;
            }
            if (cur.left == null && cur.right == null && pathSum == sum){
                res.add(new ArrayList<>(temp));
            }
            prev = cur;
            stack.pop();
            temp.remove(temp.size()-1);
            pathSum -= cur.val;
            cur = null;
        }
        return res;
    }
