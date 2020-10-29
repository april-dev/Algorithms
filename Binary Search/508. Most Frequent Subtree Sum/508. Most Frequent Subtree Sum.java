class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> res = new ArrayList<>();
        int freq = 0;
        for (int key:map.keySet()){
            if (map.get(key)>freq){
                freq = map.get(key);
                res.clear();
                res.add(key);
            }else if (map.get(key)==freq){
                res.add(key);
            }
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public int helper(TreeNode root, Map<Integer, Integer> map){
        if (root==null) return 0;
        int sum = root.val;
        sum += helper(root.left, map);
        sum += helper(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }
}


class Solution {
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        helper(root, map);
        for (int key:map.keySet()){
            if (map.get(key)==max) res.add(key);          
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public int helper(TreeNode root, Map<Integer, Integer> map){
        if (root==null) return 0;
        int sum = root.val;
        sum += helper(root.left, map);
        sum += helper(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        if (map.get(sum)>max) max = map.get(sum);
        return sum;
    }
}
