public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]>nums[right]){
                left = mid+1;
            }else{
            //this else condition includes nums[mid]<=nums[right], although nums[mid]==nums[right] will never happen (no duplicates), right = mid not mid-1 because in the case of
            //nums[mid]<nums[right], and nums[mid] is the minimum value, setting right = mid-1 will miss this value (for example [ 3,1,2])
                right = mid;
            }
        }
        return nums[left];
    }
