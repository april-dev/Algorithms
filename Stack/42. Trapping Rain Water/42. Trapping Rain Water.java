public int trap(int[] height) {
        int i=0, j=height.length-1;
        int leftmax=0, rightmax=0;
        int res = 0;
        while(i<j){
           leftmax = Math.max(leftmax, height[i]);
           rightmax = Math.max(rightmax, height[j]);
           if (leftmax<rightmax){
               res += (leftmax-height[i]);
               i++;
           }else{
               res += (rightmax-height[j]);
               j--;
           }
        }            
        return res;
    }
    
    
    //Stack (find local minimum)
    //add water horizontally, example [3,2,1,0,3]
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i=0; i<height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()]<height[i]){
                int idx = stack.pop();
                int width = stack.isEmpty()? 0: i-stack.peek()-1;
                res += (Math.min(height[i], stack.isEmpty()? 0:height[stack.peek()])-height[idx])*width;
            }
            stack.push(i);
        }
        return res;
    }
    
    
