class Solution {
    int[] p;
    int[] rank;
    int[] count;
    int[] groupCount;
    boolean[] visited;
    public int findLatestStep(int[] arr, int m) {
        p = new int[arr.length+1];
        rank = new int[arr.length+1];
        count = new int[arr.length+1];
        groupCount=new int[arr.length+1];
        visited = new boolean[arr.length+1];
        
        for (int i=1; i< p.length; i++){
            p[i] = i;
            count[i] =1;
        }
        
        int res = -1;
        int step = 1;
        for (int i:arr){
            groupCount[1]++;
            if ( i-1>=1 && visited[i-1]) union(i-1, i);
            if ( i+1<=arr.length && visited[i+1]) union(i+1, i);
            visited[i]=true;
            if (groupCount[m]!=0)  res = step;
            step++;
        }
        return res;
    }
    public int find (int i){
        if (p[i]!=i){
            p[i] = find(p[i]);
        }
        return p[i];
    }
    public void union(int i, int j){
        int pa = find(i);
        int pb = find(j);
        if (pa==pb) return;
        groupCount[count[pa]]--;
        groupCount[count[pb]]--;
        count[pa]=count[pb]=count[pa]+count[pb];
        groupCount[count[pa]]++;
        if (rank[pa]<rank[pb]){
            p[pa]=pb;
        }else{
            p[pb]=pa;
        }
        if(rank[pa]==rank[pb]) rank[pa]++;
    }
}

//alternative
public int findLatestStep(int[] arr, int m) {
        int  n = arr.length, res = -1;
        int[] length = new int[n+2], count = new int[n+1];
        for (int i=0; i<n; i++){
            int a = arr[i];
            int left = length[a-1], right = length[a+1];
            length[a] = length[a-left] = length[a + right] = left+right+1;
            count[left]--;
            count[right]--;
            count[length[a]]++;
            if (count[m]>0) res = i+1;
        }
        return res;
    }
