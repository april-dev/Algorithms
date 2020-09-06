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
