class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(n, k, 1, temp, ans);
        return ans;
    }
    public void helper(int n, int k, int index, List<Integer> temp, List<List<Integer>> ans){
        if (k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        //optimization, i <= end -k + 1, don't use i <=n
        //for (int i=index; i<=n; i++){
        for (int i=index; i<=n-k+1; i++){  
            temp.add(i);
            helper(n, k-1, i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}
