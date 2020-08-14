/*
A[i][0] is worth 1 << (N - 1) points, more than the sum of (A[i][1] + .. + A[i][N-1]).
We need to toggle all A[i][0] to 1, here I toggle all lines for A[i][0] = 0.
*/

public int matrixScore(int[][] A) {
        int m = A.length, n=A[0].length, res = (1<<(n-1))*m;
        for (int j=1; j<n; j++){
            int count = 0;
            for (int i=0; i<m; i++) count+= A[i][j]==A[i][0]? 1:0;
            res+=Math.max(count, m-count)*(1<<(n-1-j));
        }
        return res;
    }
