class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, temp, res);
        return res;
    }
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> res){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for (int i=0; i<nums.length; i++){
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(nums, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}

//not optimal because temp.contains is O(n) operation. use a boolean array.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, temp, res);
        return res;
    }
    public void helper(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i]==true) continue;
            temp.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, temp, res);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
