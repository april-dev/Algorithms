/*

*/
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
