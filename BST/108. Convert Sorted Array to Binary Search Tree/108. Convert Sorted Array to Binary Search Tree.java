//the time is O(n), since T(n) = 2T(n/2) + O(1).
/*
Time complexity: O(N) since we visit each node exactly once.

Space complexity: O(N) to keep the output, and O(logN) for the recursion stack.
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n-1);
    }
    public TreeNode helper(int[] nums, int low, int high){
        if (low>high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);
        return root;
    }
}

public class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int len = nums.length;
        if ( len == 0 ) { return null; }
        
        // 0 as a placeholder
        TreeNode head = new TreeNode(0); 
        
        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(len-1); }};
        
        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);  
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }

}
