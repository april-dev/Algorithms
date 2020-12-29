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


//solution from leetcode
public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null) return 0;
        count ^= 1 << (root.val - 1);
        int res = dfs(root.left, count) + dfs(root.right, count);
        if (root.left == root.right && (count & (count - 1)) == 0) res++;
        return res;
    }


//solution using hashset
public int pseudoPalindromicPaths (TreeNode root) {
        return canBePalindrome(root,new HashSet());
    }
    
    private int canBePalindrome(TreeNode node,Set<Integer> numbers){
        if(node==null) return 0;
        if(numbers.contains(node.val)){
            numbers.remove(node.val);
        }else{
            numbers.add(node.val);
        }
        if(node.left==null&& node.right==null){
            return numbers.size()<=1?1:0; // thanks to @MananS77
        }
        int left=canBePalindrome(node.left,new HashSet(numbers));
        int right=canBePalindrome(node.right,new HashSet(numbers));
        return left+right;
    }

