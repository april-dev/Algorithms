
//based on Q84. Largest Rectangle in Histogram
class Solution {
    public int maximalRectangle(char[][] matrix) {
       int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        int[] h = new int[n];
        int res = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j]=='1') h[j]++;
                else h[j] =0;
            }
            res = Math.max(res, largestRectangleArea(h));
        }
        return res;
    }
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
}
