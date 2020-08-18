public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length, n=B.length;
        List<int[]> res = new ArrayList<>();
        if (m==0 || n==0) return new int[0][];
        int i=0, j=0;
        while (i<m && j<n){
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            
            if (left<=right) res.add(new int[]{left, right});
            /*
            if (A[i][1]==right) i++;
            if (B[j][1]==right) j++;
            */
            if (A[i][1]<B[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
