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
