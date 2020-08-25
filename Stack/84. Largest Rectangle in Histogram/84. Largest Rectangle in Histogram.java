public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        if (heights == null || n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n-1] = n;
        
        for (int i=0; i<=n; i++){
            while (!stack.isEmpty() && heights[stack.peek()]>(i==n? 0:heights[i])){
                int idx = stack.pop();
                left[idx] = stack.isEmpty()? -1:stack.peek();
                right[idx] = i;
            }
            stack.push(i);
        }
        int res=0;
        for (int i=0; i<n; i++){
            res = Math.max(res, heights[i]*(right[i]-left[i]-1));
        }
        return res;
    }



//shortened
public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int res=0;
        if (heights == null || n == 0) return 0;
        
        for (int i=0; i<=n; i++){
            
            while (!stack.isEmpty() && heights[stack.peek()]>(i==n? 0:heights[i])){
                int idx = stack.pop();
                res = Math.max(res, heights[idx]*(i-(stack.isEmpty()? -1:stack.peek())-1));
            }
            
            stack.push(i);
        }
        return res;
    }
