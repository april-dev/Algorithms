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


//Stack Solution
public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
