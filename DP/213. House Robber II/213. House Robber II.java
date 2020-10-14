/*
At the first glance, I think the perfect way to split the problem is 1. not rob the 1st house; 2. rob 1st house, 
because 1 and 2 won't have any intersection (code below follows this idea and beats 100%). 
However, the way this solution splits this problem is 1. not rob the 1st house; 2. not rob the last house. 
As you can see, the second statement of these two split strategies are different and they are not logically equal 
because "not rob the last house" means you can choose to rob the 1st house or not. Then why it is still correct? 
It is because the 2nd statement from the 2nd strategy contains the 2nd statement from the 1st strategy. 
In other words, the 2nd set has some overlap with the 1st set in the 2nd strategy. Since our goal is only to find the max, it is okay to include some overlap.
*/
public int robhelper(int[] nums, int low, int high){
        int pre_i2=0;
        int pre_i1=0;
        for (int i=low;i<=high;i++){
            
            int cur= Math.max(pre_i2 + nums[i],pre_i1);
            pre_i2 = pre_i1;
            pre_i1 = cur;
                       
        }
        return pre_i1;
    }
   
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        return Math.max(robhelper(nums,0,nums.length-2),robhelper(nums,1,nums.length-1));
    }
