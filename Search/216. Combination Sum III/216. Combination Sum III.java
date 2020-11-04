class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(k, n, 1, temp, res);
        return res;
    }
    public void helper(int k, int target, int index, List<Integer> temp, List<List<Integer>> res){
        if (k==0 && target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        //One optimization:
        //for (int i=index; i<=target && i<=9; i++){
        for (int i=index; i<=9; i++){
            temp.add(i);
            helper(k-1, target-i, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
