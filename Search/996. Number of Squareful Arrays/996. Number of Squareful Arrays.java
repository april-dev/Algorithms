//It's O(N!) if we have N different numbers and any pair sum is square.

class Solution {
    int res = 0;
    HashMap<Integer, Integer> cnt = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    public int numSquarefulPerms(int[] A) {     
        for (int a:A) cnt.put(a, cnt.getOrDefault(a, 0)+1);
        for (int key1:cnt.keySet()){
            for (int key2:cnt.keySet()){
                if (!map.containsKey(key1)) map.put(key1, new HashSet<>());
                int s = (int)  Math.sqrt(key1+key2);
                if (s*s == key1 + key2) map.get(key1).add(key2);
            }
        }
        for (int key:cnt.keySet()) dfs(key, A.length-1);
        return res;
    }
    public void dfs(int num, int left){
        cnt.put(num, cnt.get(num)-1);
        if (left==0) {
            res++;
            cnt.put(num, cnt.get(num)+1);
            return;
        }             
        for (int neighbor:map.get(num)){
            if (cnt.get(neighbor)>0) dfs(neighbor, left - 1);
        }
        cnt.put(num, cnt.get(num)+1);
    }
}
//alternatives for function dfs
public void dfs(int num, int left){
       if (left==0) {
            res++;
            return;
        }   
        
        cnt.put(num, cnt.get(num)-1);
        
        for (int neighbor:map.get(num)){
            if (cnt.get(neighbor)>0) dfs(neighbor, left - 1);
        }
        
        cnt.put(num, cnt.get(num)+1);
    }
    
//alternatives 2 for function dfs
public void dfs(int num, int left){
       if (left==0) {
            res++;
            //return;
        }   
        
        cnt.put(num, cnt.get(num)-1);
        
        for (int neighbor:map.get(num)){
            if (cnt.get(neighbor)>0) dfs(neighbor, left - 1);
        }
        
        cnt.put(num, cnt.get(num)+1);
    }
    
 //alternatives 3 for function dfs
 public void dfs(int num, int left){
        cnt.put(num, cnt.get(num)-1);
        if (left==0) {
            res++;
        }             
        for (int neighbor:map.get(num)){
            if (cnt.get(neighbor)>0) dfs(neighbor, left - 1);
        }
        cnt.put(num, cnt.get(num)+1);
    }



//Use Q47. Permutations II
class Solution {
    int res = 0;
    public int numSquarefulPerms(int[] A) { 
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        dfs(A, -1, visited, 0);
        return res;
    }
    public void dfs(int[] A, int last, boolean[] visited, int curCount){  
        if (curCount==A.length){
            res++;
            return;
        }
        for (int i=0; i<A.length; i++){
            if (visited[i]==true || i>0 && A[i]==A[i-1] && visited[i-1]==false) continue;
            if (last!=-1 && valid(A[last], A[i])==false) continue;
            visited[i] = true;
            dfs(A, i, visited, curCount+1);
            visited[i] = false;
        }       
    }
    public boolean valid(int a, int b){
        int c = (int) Math.sqrt(a + b);
        return c*c==a+b;
    }
}
