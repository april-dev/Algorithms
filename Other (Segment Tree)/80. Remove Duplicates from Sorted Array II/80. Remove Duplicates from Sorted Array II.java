public int removeDuplicates(int[] nums) {
        int i=0; 
        for (int n: nums){
            if (i<2 || n != nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }
    
//can be generalized to at most K duplicates
int removeDuplicates(vector<int>& nums, int k) {
    int i = 0;
    for (int n : nums)
        if (i < k || n > nums[i-k])
            nums[i++] = n;
    return i;
}
