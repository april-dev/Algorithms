//Divide and conquer O(nlogn) 
public int majorityElement(int[] nums) {
     return helper(0, nums.length-1, nums);
    }
    
    public int helper(int left, int right, int[] nums){
        if (left==right) return nums[left];
        int mid = left + (right-left)/2;
        int lm = helper(left, mid, nums);
        int rm = helper(mid+1, right, nums);
        if (lm==rm) return lm;
        int c1=0, c2=0;
        for (int i=left; i<right+1; i++){
            if (nums[i]==lm) c1++;
            else if (nums[i]==rm) c2++;
        }
        return c1>c2? lm:rm;
    }
    
    //Moore voting algorithm
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
    
    //Bit Manipulation
    public int majorityElement(int[] nums) {
    int[] bit = new int[32];
    for (int num: nums)
        for (int i=0; i<32; i++) 
            if ((num>>(31-i) & 1) == 1)
                bit[i]++;
    int ret=0;
    for (int i=0; i<32; i++) {
        bit[i]=bit[i]>nums.length/2?1:0;
        ret += bit[i]*(1<<(31-i));
    }
    return ret;
