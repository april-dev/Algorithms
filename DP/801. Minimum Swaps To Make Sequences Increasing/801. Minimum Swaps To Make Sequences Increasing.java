//O(2^N) TLE
int ans = Integer.MAX_VALUE;
    public int minSwap(int[] A, int[] B) {

        dfs(A, B, 0, 0);
        return ans;
    }
    public void dfs(int[] A, int[] B, int i, int c) {
        if (c >= ans) return;

        if (i == A.length) {
            ans = Math.min(ans, c);
            return;
        }

        if (i == 0 || A[i] > A[i - 1] && B[i] > B[i - 1])
            dfs(A, B, i + 1, c);

        if (i == 0 || A[i] > B[i - 1] && B[i] > A[i - 1]) {
            swap(i, A, B);
            dfs(A, B, i + 1, c + 1);
            swap(i, A, B);
        }
    }
    public void swap(int i, int[] A, int[] B){
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }
    
    
    //DP
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] not_swap = new int[n];
        Arrays.fill(swap, Integer.MAX_VALUE);
        Arrays.fill(not_swap, Integer.MAX_VALUE);
        swap[0] = 1;
        not_swap[0] = 0;
        //reason why only second if condition takes min is in case two if conditions are all satisfied, then the second if needs to take min.
        for (int i=1; i<n; i++){
            if (A[i-1]<A[i] && B[i-1]<B[i]){
                swap[i] = swap[i-1] +1;
                not_swap[i] = not_swap[i-1];
            }
            if (A[i-1]<B[i] && B[i-1]<A[i]){
                swap[i] = Math.min(swap[i], not_swap[i-1] +1);
                not_swap[i] = Math.min(not_swap[i], swap[i-1]);
            }
        }
        return Math.min(swap[n-1], not_swap[n-1]);
        
    }
