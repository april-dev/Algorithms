/*
 Each number in candidates may only be used once in the combination
 The solution set must not contain duplicate combinations.
 
 if (i>index && candidates[i]==candidates[i-1]) continue;
 1.  this line below is the only difference between this question and Q39 Combination Sum
 2.  it is used to skip duplicate combinations, not duplicate numbers. array might contain duplicate numbers and duplicate numbers can appear in the same combination
 Example, candidates = [10,1,2,7,6,1,5], target = 8,
 correct answer should be [[1,1,6],[1,2,5],[1,7],[2,6]],
 however, without the code above, the answer would be [[1,1,6],[1,2,5],[1,7],[1,2,5],[1,7],[2,6]]. This is because after the array is sorted [1, 1, 2, 5, 6, 7, 10] and the answers
 [1, 2, 5] and [1, 7] are counted twice.
*/
class Solution {    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, temp, ans);
        return ans;
    }
    public void helper(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> ans){
        if (target<0) return;
        if (target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<candidates.length && target>=candidates[i]; i++){
           
            if (i>index && candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }   
}
