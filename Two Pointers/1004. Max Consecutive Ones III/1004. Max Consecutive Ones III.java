//equivalent to finding the longest subarray with at most K zeros.


//window size does not shrink
public int longestOnes(int[] A, int K) {
        int i=0, j=0;
        int res = 0;
        
        while (j<A.length){
            if (A[j]==0) K--;
            if (K<0){
                if(A[i]==0) K++;
                i++;
            }
            j++;
        }
        return j-i;
    }
    
    //Regular Sliding window
    public int longestOnes(int[] A, int K) {
        int i=0, j=0;
        int res = 0;
        
        while (j<A.length){
            if (A[j]==0) K--;
            if (K<0){
                if(A[i]==0) K++;
                i++;
            }
            j++;
        }
        return j-i;
    }
