/*
Denote the time complexity for N nodes as T(N).

Suppose we do have that balanced tree now (and also N is 2^N-1 for simplicity of discussion). 
Amd we know that N/2 nodes lie at the leaf/deepest level of the BST since it's balanced binary tree.

We easily have this recurrence formula:
T(N) = T(N/2) + (N/2) * lgN

Which means, we have N nodes, with half lying on the deepest (the lgNth) level. 
The sum of path lengths for N nodes equals to sum of path lengths for all nodes except those on the lgN-th level plus the sum of path lengths for those nodes on the lgN-th level.

This recurrence is not hard to solve. I did not try to work out the exact solution since the discussion above in itself are in essence a little blurry on corner cases, 
but it is easy to discover that T(N) = O(NlgN).
In conclusion, the complexity of this program is Ω(NlgN) ~ O(N^2).

For example, If you have a straight line:
1 - 2 - 3 - 4 - 5 - 6 - 7
with 1 as the root, then the sum of the all the length of root-to-node paths would be, with the length defined as the number of nodes 
along the path rather than the number of edges:
1 + 2 + 3 + 4 + 5 + 6 + 7
in the case of N nodes, this sum os O(N^2).
The strings that are created and passed (to the recursive call to the next node) in the above case would be:
"1"
"1->2"
"1->2->3"
...
"1->2->3->4->5->6->7"

main cost incurred in this algorithm is a result of the immutability of String and the consequent allocation and copying.
Using StringBuilder, we could make sure that String allocation and copying only happens when we are at a leaf. 
That means, the cost would be now sum of length of all root-to-leaf paths rather than sum of length of all root-to-node paths. 
This is assuming that StringBuilder.append and StringBuilder.setLength can work in O(1) or at least less than O(N) time.

In the case of using stringBuilder,the best case is when all nodes lies on the same side, i.e. when they form a linked list. And the time complexity will be O(N) * 1 = O(N).
The worst case is a balanced binary tree. The time complexity is O(lgN) * O(N) = O(N lgN). So it will be O(N) - O(N lgN) time complexity and also space complexity.
*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    public void helper(TreeNode root, String s, List<String> res){
        if (root==null) return;
        
        if (root.left==null && root.right==null){
            s = s+ root.val;
            res.add(s);
        }
        s = s+ root.val + "->";
        helper(root.left, s, res);
        helper(root.right, s, res);
    }
}

//StringBuilder
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
    }
    public void helper(TreeNode root, StringBuilder sb, List<String> res){
        if (root==null) return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left==null && root.right==null){
            res.add(sb.toString()); 
        }else{
            sb.append("->");
            helper(root.left, sb, res);
            helper(root.right, sb, res);
        }
        sb.setLength(len);       
    }
}
