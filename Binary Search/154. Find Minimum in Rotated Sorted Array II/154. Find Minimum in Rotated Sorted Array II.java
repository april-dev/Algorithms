//This code is correct to return the minimum value of the array. But in terms of "find the minimum value index" it is not right.
//Consider this case: 1 1 1 1 1 1 1 1 2 1 1
//the min index returned is 0, while actually it should be 9.
//For this case: 2 2 2 2 2 2 2 2 1 2 2
//it will return the correct index, which is 8.

//The reason is, the pivot index will be passed by at hi--. To avoid this, we can add the following judgement:
/*
else {
    if (nums[hi - 1] > nums[hi]) {
        lo = hi;
        break;
    }
    hi--;
}
*/


public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[hi]) { 
                lo = mi + 1;
            }
            else if (nums[mi] < nums[hi]) { 
                hi = mi;                
            }
            else {
                
                hi--;
            }
        }
        
        return nums[lo];
    }
