/*
time complexity of this is O(#candidates^target) because the height of the tree would be target and degree of each node would be number of candidates. 
Space complexity is O(target).
A more accurately expression may be O(#candidates^(target/min of candidates))
because maximum depth of recursion will be target / minimum value of candidate.
suppose, input is [2,3,4,5], 24
the max depth will be for element 2 -> [2,2,2,2,2,2,2,2,2,2,2,2] i.e. 12
*/

/*
Time complexity is O(N^target) where N is a length of candidates array.
Space complexity is O(target).
This is worst case and without any optimization, like moving position forward and sorting to stop early.
Just assuming that each recursive step we go over all existing candidates, so base N.
And go as deep as target in our recursive calls (if candidates are close to 1), so power of target.
*/

/*
sorting array is only useful when combined with target>=candidates[i]
Say remain is 7, and you have numbers 8,9,10,11,12,13,14,15,16....... up to a huge number.

If you put the condition in the for loop, it'll break out as soon as you see '8'. Otherwise, it'll check through all the numbers even when it could have just stopped after 8.
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, temp, ans);
        return ans;
    }
    public void helper(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> ans){
        //With sorting and the target>=candidates[i] condition below, the first if statement is unnecessary
        if (target < 0 ) return;
        if (target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }     
        for (int i=index; i<candidates.length && target>=candidates[i]; i++){
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], i, temp, ans);
            temp.remove(temp.size()-1);
        }       
    }
}
