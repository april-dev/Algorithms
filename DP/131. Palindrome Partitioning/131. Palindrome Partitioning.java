//DFS
//Time complexity: O(2^n)
//Space complexity: O(n)
public List<List<String>> partition(String s) {
        List<String> tempList = new ArrayList<>();
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(s,0, tempList, res);
        return res;
        
    }
    
    public void dfs(String s, int pos, List<String> tempList, List<List<String>> res){
        if (pos==s.length()) res.add(new ArrayList<String>(tempList));
        for (int i=pos; i<s.length(); i++){
            if (isPal(s, pos, i)==true){
                tempList.add(s.substring(pos,i+1));
                dfs(s, i+1, tempList, res);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    
    public boolean isPal(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
    
    //DP
    //Time complexity: O(2^n)
    //Space complexity: O(2^n)
    class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[] dp = new ArrayList[n+1];
        
    for (int len=1; len<=n; ++len){
            for (int i=0; i<len; ++i){
                String right = s.substring(i, len);
                if (!isPalindrome(right)) continue;
                if (i==0) {
                    List<String> temp1 = new ArrayList<>();
                    List<List<String>> temp2 = new ArrayList<>();
                    temp1.add(right);
                    temp2.add(temp1);

                    if (dp[len]==null){
                        dp[len]=new ArrayList<>(temp2);
                    }else{
                        dp[len].add(new ArrayList<>(temp1));
                    }
                }
                if (dp[i]!=null){
                    for (List<String> list:dp[i]){
                        if (dp[len]==null){
                            List<List<String>> temp3 = new ArrayList<>();
                            temp3.add(new ArrayList<>(list));
                            dp[len]= new ArrayList<>(temp3);
                        }else{
                            dp[len].add(new ArrayList<>(list));
                        }

                        dp[len].get(dp[len].size()-1).add(right);
                    }
                }
            }
        }
        return dp[n];
        
    }

    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
