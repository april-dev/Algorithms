//My solution
public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        for (int[] pair: trust){
            int p1 = pair[0];
            int p2 = pair[1];
            inDegree[p2]++;
            outDegree[p1]++;
        }
        for (int i=1; i<=N; i++){
            if (inDegree[i]==N-1 && outDegree[i]==0) return i;
        }
        return -1;
    }


//solution from Leetcode
public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t:trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i=1; i<=N; i++){
            if (count[i]==N-1) return i;
        }
        return -1;
    }
