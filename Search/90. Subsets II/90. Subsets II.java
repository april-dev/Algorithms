class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, temp, res);
        return res;
    }
    public void helper(int[] nums, int index, List<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for (int i=index; i<nums.length; i++){
            if (i>index && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            helper(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}


/*
 how many subsets are there if there are duplicate elements? We can treat duplicate element as a spacial element. 
 For example, if we have duplicate elements (5, 5), instead of treating them as two elements that are duplicate, we can treat it as one special element 5, 
 but this element has more than two choices: you can either NOT put it into the subset, or put ONE 5 into the subset, or put TWO 5s into the subset. 
 Therefore, we are given an array (a1, a2, a3, ..., an) with each of them appearing (k1, k2, k3, ..., kn) times, the number of subset is (k1+1)(k2+1)...(kn+1)
*/
public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        res.add(temp);
        
        for (int i=0; i<nums.length; i++){
            int dup = 0;
            while (i+1<nums.length && nums[i+1]==nums[i]){
                dup++;
                i++;
            }
            int size = res.size();
            for (int j=0; j<size; j++){
                List<Integer> element = new ArrayList<>(res.get(j));
                for (int t=0; t<=dup; t++){
                    element.add(nums[i]);
                    res.add(new ArrayList<>(element));                   
                }
            }
        }
        return res;
    }   
