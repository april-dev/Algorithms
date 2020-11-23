/*
Time Complexity: What basically we are doing is, we are traversing the entire nums array for each subset 
(once we are done with one subset, for the next subset we are starting again with index 0). So for each subset, we are choosing the suitable elements 
from the nums array (basically iterate over nums and for each element either use it or drop it, which is O(2^n) operation where n is the size of nums). 
We are doing the same for each subset. Total subsets are k. So Time Complexity becomes O(k*(2^n)).

Space Complexity: Even though we are traversing the entire array for each subset, the height of the recursion tree would still remain O(n) because 
we won't be calling the recursive function for already visited elements. Also, O(n) for the visited array. So the Space Complexity 
becomes stack size + visited array = O(n)+O(n) = O(n).
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k){
        int sum = 0;
        for (int num:nums) sum+=num;
        if (sum%k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, 0, sum/k, 0, visited);
    }
    public boolean dfs(int[] nums, int k, int start, int target, int sum, boolean[] visited){
        if (sum>target) return false;
        if (k==1) return true;
        if (sum==target) return dfs(nums, k-1, 0, target, 0, visited);
        
        for (int i=start; i<nums.length; i++) {
            if (visited[i]) continue;
            visited[i]= true;
            if (dfs(nums, k, i+1, target, sum+nums[i], visited)) return true;
            visited[i]=false;
        }
        return false;
    }
}
