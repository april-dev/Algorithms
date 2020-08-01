public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int n:nums){
            sum+=n;
            max = Math.max(max, n);
        }
        int left = max, right = sum;
        while (left<right){
            int mid = left + (right - left)/2;
            if (valid(mid, nums, m)){
                right = mid;
            }else{
                left = mid+1;
            }
            
        }
        return left;
        
    }
    public boolean valid(int target, int[]nums, int m){
        int sum = 0, count=1;
        for (int n:nums){
            sum+=n;
            if (sum>target){
                sum = n;
                count += 1;
                if (count>m) return false;
            }
        }
        return true;
    }
    
    
    //Solution 2
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
