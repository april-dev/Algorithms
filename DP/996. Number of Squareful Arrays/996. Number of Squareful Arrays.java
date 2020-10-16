//Time complexity: O(n!)
/*
if (i>0 && A[i]==A[i-1] && visited[i-1]==0) continue;
Say you have [2,2,2], we mark them as [2(1), 2(2), 2(3)],
Now you are currently visiting 2(3), and the list contains 2(1). 2(2) is not visited. you add 2(3) to your list, so the list contains [2(1), 2(3)].
Then you go to next recursion, this time you find 2(2) is not visited, if you add 2(2) into list, the list will be [2(1), 2(3), 2(2)], which is also a valid answer.
But the problem is that this valid answer is duplicated from [2(1), 2(2), 2(3)], so if we add [2(1), 2(3), 2(2)] into result, the result will be duplicated.
And it's the standard way to remove duplication when we do permutation on an array which contains duplicated number. And that's why I sort the whole array before 
jump into the backtracking - to prevent the duplication by grouping the same number together and make the removal of duplication easier.
*/
class Solution {
    int res = 0;
    public int numSquarefulPerms(int[] A) {
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[A.length];
        Arrays.sort(A);
        helper(A, list, visited);
        return res;        
    }
    
    public void helper(int[]A, List<Integer> list, int[] visited){
        if (list.size()==A.length) {
            res++;
            return;
        }
        for (int i=0; i<A.length; i++){
            
            if (visited[i]==1) continue;
            if (i>0 && A[i]==A[i-1] && visited[i-1]==0) continue;
            if (!list.isEmpty()){
                int sum = list.get(list.size()-1) + A[i];
                if (!isValid(sum)) continue;            
            }
            
            visited[i] = 1;
            list.add(A[i]);
            helper(A, list, visited);
            list.remove(list.size()-1);
            visited[i] = 0;           
        }
    }
    
    public boolean isValid(int sum){
        int s = (int) Math.sqrt(sum);
        return s*s == sum;
    }
}

//No global variable
class Solution {
    public int numSquarefulPerms(int[] A) {
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[A.length];
        Arrays.sort(A);
        return helper(A, list, visited);      
    }
    
    public int helper(int[]A, List<Integer> list, int[] visited){
        if (list.size()==A.length) {
            return 1;
        }
        
        int res = 0;
        for (int i=0; i<A.length; i++){
            
            if (visited[i]==1) continue;
            if (i>0 && A[i]==A[i-1] && visited[i-1]==0) continue;
            if (!list.isEmpty()){
                int sum = list.get(list.size()-1) + A[i];
                if (!isValid(sum)) continue;            
            }
            
            visited[i] = 1;
            list.add(A[i]);
            res += helper(A, list, visited);
            list.remove(list.size()-1);
            visited[i] = 0;           
        }
        return res;
    }
    
    public boolean isValid(int sum){
        int s = (int) Math.sqrt(sum);
        return s*s == sum;
    }
}

//DP: Hamiltoninan Path
public int numSquarefulPerms(int[] A) {
       int n = A.length;
       int[][] dp = new int[1<<n][n];
       int[][] graph = new int[n][n];
       Arrays.sort(A);
       for (int i=0; i<n; i++){
           for (int j=0; j<n; j++){
               if (i==j) continue;
               int r = (int) Math.sqrt(A[i] + A[j]);
               if (r * r == A[i] + A[j]) graph[i][j] = 1;
           }
       }
       for (int i=0; i<n; i++){
           if (i==0 || A[i]!=A[i-1]) dp[(1<<i)][i] = 1;
       }
       for (int s=0; s<(1<<n); s++){//for (int s=0; s<(1<<n)-1; s++){ also works, (1<<n)-1 is redundant because all of the digits have been visited, will be caught at line 109
           for (int i=0; i<n; i++){
               if (dp[s][i]==0) continue;
               for (int j=0; j<n; j++){
                   if (graph[i][j]==0) continue;
                   if ((s & (1<<j))!=0) continue;//initially stuck at ((s & (1<<j))==1) (wrong)
                   if (j>0 && (s & (1<<(j - 1)))==0 && A[j] == A[j-1]) continue;
                       dp[s | (1<<j)][j] += dp[s][i];
               }
           }
       }
        int res = 0;
        for (int i=0; i<n; i++){
            res += dp[(1<<n) - 1][i];
        }
        return res;
    }
