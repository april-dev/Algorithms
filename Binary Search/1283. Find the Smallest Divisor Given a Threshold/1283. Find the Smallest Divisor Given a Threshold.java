public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1, right = (int)1e6;
 
        while (left<right){
            int mid = left + (right - left)/2;
            int sum = 0;
            for (int num:nums){
                //sum+= (num+mid-1)/mid;
                sum+= (int) Math.ceil((float)num/mid);
            }
            if (sum>threshold){
                left = mid+1;
            }else{
                 right = mid;
            }
        }
        return left;
    }
