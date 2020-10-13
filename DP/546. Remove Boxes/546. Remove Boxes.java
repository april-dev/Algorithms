class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] m = new int[n][n][n];
        return helper(boxes, 0, n-1, 0, m);
    }
    public int helper(int[] boxes, int i, int j, int k, int[][][] m){
        if (i>j) return 0;
        if (m[i][j][k]>0) return m[i][j][k];
        m[i][j][k] = helper(boxes, i, j-1, 0, m) + (k+1)*(k+1);
        for (int l=i; l<j; l++){
            if (boxes[l]==boxes[j]) 
            m[i][j][k] = Math.max(m[i][j][k], helper(boxes, i, l, k+1, m) + helper(boxes, l+1, j-1, 0, m));
        }
        return m[i][j][k];
    }
}
