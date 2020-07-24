public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums.length==0 || nums==null) return res;
        int left = 0, right = nums.length-1;
        while (left<right){
            int mid = left + (right - left)/2;
            if (nums[mid]<target) {
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if (nums[right]!=target) { //left or right does not matter
            return res;
        }else{
            res[0] = right;
        }
        right = nums.length -1;
        while (left<right){
            int mid = left + (right - left)/2 + 1;
            if (nums[mid]>target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        res[1] = left; //left or right does not matter
        return res;
    }
