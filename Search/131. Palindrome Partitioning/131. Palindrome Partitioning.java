/*
Time complexity: O(n*(2^n))
For a string with length n, there will be (n - 1) intervals between chars.
For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
For every partition way, we need to check if it is palindrome, which is O(n).
So the time complexity is O(n*(2^n))
*/

/*
T(n)=T(n-1)+T(n-2)+..+T(1)

T(n+1)=T(n)+T(n-1)+..+T(1)

T(n+1)=2T(n)

T(n)=2^n
*/



//my solution
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(s, 0, temp, res);
        return res;
    }
    public void backtrack(String s, int index, List<String> temp, List<List<String>> res){
        if (index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }       
        for (int i=1; i<=s.length(); i++){
            if (index+i>s.length()) break;
            String cur = s.substring(index, index+i);
            if (!isValid(cur)) continue;
            temp.add(cur);
            backtrack(s, index+i, temp, res);
            temp.remove(temp.size()-1);
        }
    }
    public boolean isValid(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}


//better
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(s, 0, temp, res);
        return res;
    }
    public void backtrack(String s, int index, List<String> temp, List<List<String>> res){
        if (index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }       
        for (int i=index; i<s.length(); i++){
            String cur = s.substring(index, i+1);
            if (isValid(cur)) {
                temp.add(cur);
                backtrack(s, i+1, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isValid(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
