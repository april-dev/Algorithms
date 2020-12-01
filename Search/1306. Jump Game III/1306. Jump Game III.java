//BFS
public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if (arr[cur]==0) return true;
            int left = cur - arr[cur];
            int right = cur + arr[cur];
            if (left>=0 && set.add(left)) queue.add(left);              
            if (right<arr.length && set.add(right)) queue.add(right);
        }
        return false;
    }
    
//DFS
class Solution {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(arr, start, set);
    }
    public boolean dfs(int[] arr, int index, HashSet<Integer> set){
        if (index<0 || index>=arr.length) return false;
        if (set.contains(index)) return false;
        if (arr[index]==0) return true;       
        
        set.add(index);
        if (dfs(arr, index-arr[index], set)==true) return true;
        if (dfs(arr, index+arr[index], set)==true) return true;
        return false;
    }
}

//DFS2
class Solution {
    public boolean canReach(int[] arr, int start) {
     if(start<0 || start>=arr.length || arr[start]<0) return false;
        if(arr[start] == 0) return true;

        arr[start] = -arr[start];
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}
