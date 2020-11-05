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


//Solution 2: Swap values
public class Solution {
public List<List<Integer>> permute(int[] num) {
 List<List<Integer>> result = new ArrayList<List<Integer>>(); 
 permute(num,0,result);
 return result;}


 public void permute(int[] num, int begin, List<List<Integer>> result){
    if(begin>=num.length){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<num.length;i++){
            list.add(num[i]);
        }
        result.add(list);
        return;
    }
    for(int i=begin;i<num.length;i++){
        swap(begin,i,num);
        permute(num,begin+1,result);
        swap(begin,i,num);
        
    }
}

public void swap (int x, int y,int[] num){
    int temp = num[x];
    num[x]=num[y];
    num[y]=temp;
} }


//Solution 3: Iterative
/*
For example, if the input num[] is {1,2,3}: First, add 1 into the initial List<List<Integer>> (let's call it "answer").

Then, 2 can be added in front or after 1. So we have to copy the List in answer (it's just {1}), add 2 in position 0 of {1}, 
then copy the original {1} again, and add 2 in position 1. Now we have an answer of {{2,1},{1,2}}. There are 2 lists in the current answer.

Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0; then copy {2,1} and {1,2}, and add 3 into position 1, then do the
same thing for position 3. Finally we have 2*3=6 lists in answer, which is what we want.
*/

public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length==0) return ans;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        ans.add(temp);
        for (int i=1; i<nums.length; i++){
            List<List<Integer>> newAns = new ArrayList<>();
            for (List<Integer> list: ans){
                for (int j=0; j<=i; j++){
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j, nums[i]);
                    newAns.add(new ArrayList<>(newList));
                }
            }
            ans = newAns;
        }
        return ans;
    }
