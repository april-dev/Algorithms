class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, visited, temp, res);
        return res;
    }
    public void helper(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i]) continue;
            if (i>0 && nums[i] == nums[i-1] && visited[i-1]==false) continue;         
            temp.add(nums[i]);
            visited[i]=true;
            helper(nums, visited, temp, res);
            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}

//HashMap
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return results;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        permuteUniqueHelper(map, nums.length, new Integer[nums.length], 0, results);
        return results;
    }
    
    private void permuteUniqueHelper(Map<Integer,Integer> m, int l, Integer[] p, int i, List<List<Integer>> r) {
        if(i == l) {
            r.add(Arrays.asList(Arrays.copyOf(p,l)));
            return;
        }
        for(int key : m.keySet()) {
            if(m.get(key) > 0) {
                m.put(key,m.get(key)-1);
                p[i] = key;
                permuteUniqueHelper(m,l,p,i+1,r);
                m.put(key,m.get(key)+1);
            }
        }
    }
}
