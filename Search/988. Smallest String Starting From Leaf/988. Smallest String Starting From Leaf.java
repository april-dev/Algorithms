//my solution
class Solution {
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return res;
    }
    public void helper(TreeNode root, String s){
        if (root==null) return;
        s = (char)(root.val+'a') + s;
        if (root.left==null && root.right==null) {
            if (res=="" || s.compareTo(res)<0) res=s;
            return;
        }
        helper(root.left, s);
        helper(root.right, s);
    }
}

//Alternative 1
private String ans = "~"; // dummy value '~' > 'z'
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    private String dfs(TreeNode n, String str) {
        if (n == null) { return str; } // base case, and in case root is null.
        str = (char)(n.val + 'a') + str; // prepend current char to the path string from root.
        if (n.left == null && n.right == null && ans.compareTo(str) > 0) { ans = str; } // update ans if n is a leaf.
        dfs(n.left, str); // recursion to the left branch.
        dfs(n.right, str); // recursion to the right branch.
        return ans;
    }

//Alternative 2 using string builder
public String smallestFromLeaf(TreeNode root) {
    
    String[] result = new String[]{null};
    helper(result, new StringBuilder(), root);
    
    return result[0];
}

private void helper(String[] result, StringBuilder currPath, TreeNode currNode) {
    
    if (currNode == null) return;
    
    currPath.append((char)('a' + currNode.val));
    
    if (currNode.left == null && currNode.right == null) {
        
        String candidate = new StringBuilder(currPath).reverse().toString();   // reverse because paths should be from leaf to root and not from root to leaf
        if (result[0] == null || result[0].compareTo(candidate) > 0) {
            result[0] = candidate;   
        }
        
    } else {
        helper(result, currPath, currNode.left);
        helper(result, currPath, currNode.right);
    }
    
    currPath.setLength(currPath.length() - 1);      // backtrack
}
