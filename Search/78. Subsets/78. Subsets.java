class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, temp, res);
        return res;
    }
    public void helper(int[] nums, int index, List<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for (int i=index; i<nums.length; i++){
            temp.add(nums[i]);
            helper(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}

//Bit manipulation
public List<List<Integer>> subsets(int[] S) {
	Arrays.sort(S);
	int totalNumber = 1 << S.length;
	List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
	for (int i=0; i<totalNumber; i++) {
		List<Integer> set = new LinkedList<Integer>();
		for (int j=0; j<S.length; j++) {
			if ((i & (1<<j)) != 0) {
				set.add(S[j]);
			}
		}
		collection.add(set);
	}
	return collection;
}
