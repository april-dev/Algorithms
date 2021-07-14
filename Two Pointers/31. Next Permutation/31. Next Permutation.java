class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = 0, l=0;
        for (k=n-2; k>=0; k--){
            if (nums[k]<nums[k+1]) break;
        }
        if (k<0) reverse(nums, 0, n-1);
        else{
            for (l=n-1; l>k; l--){
                if (nums[l]>nums[k]) break;
            }
            int temp = nums[l];
            nums[l] = nums[k];
            nums[k] = temp;
            reverse(nums, k+1, n-1);
        }
    }
    public void reverse(int[] nums, int i, int j){
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }
}
