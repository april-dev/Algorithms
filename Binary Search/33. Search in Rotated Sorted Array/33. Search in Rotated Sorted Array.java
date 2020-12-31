
// see 81 for duplicates

//same template as Q81
public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid]<=nums[right]){
                if (target > nums[mid] && target <=nums[right]) left = mid + 1;
                else right = mid - 1;
                    
            }
            else{
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
                    
            }
        }
        return -1;
    }

//alternative solution
public int search(int[] nums, int target) {
       if (nums == null || nums.length == 0) return -1;
        
       int left = 0, right = nums.length-1;
        int start = 0;
        //1. find index of the smallest element
        while(left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                left = mid +1;
            } else right = mid;
        }
        
     //2. figure out in which side our target lies
        start = left;
        left = 0;
        right = nums.length-1;
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else right = start;
        
     //3. Run normal binary search in sorted half.
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            
            if (nums[mid] > target) right = mid-1;
            else left = mid + 1;
        }
        
        return -1;
    }
