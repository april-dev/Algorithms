public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n==0) return 0;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight = new int[n];
        lessFromLeft[0] = -1;
        lessFromRight[n-1] = n;
        for (int i=1; i<n; i++){
            int p = i-1;
            while (p>=0 && heights[p]>=heights[i]){
                p--;
            }
            lessFromLeft[i] = p;
        }
        for (int i=0; i<n-1; i++){
            int p = i+1;
            while (p<=n-1 && heights[p]>=heights[i]){
                p++;
            }
            lessFromRight[i] = p;
        }
        int res = 0;
        for (int i=0; i<n; i++){
            res = Math.max(res, (lessFromRight[i]-lessFromLeft[i]-1)*heights[i]);
        }
        return res;
    }
