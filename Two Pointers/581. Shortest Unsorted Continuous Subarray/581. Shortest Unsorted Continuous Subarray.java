public int findUnsortedSubarray(int[] nums) {
        int end = -2, beg = -1;
        int n = nums.length;
        int max=nums[0], min = nums[n-1];
        for (int i=1; i<n; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[n-1-i], min);
            if (nums[i]<max) end = i;
            if (nums[n-i-1]>min) beg = n-i-1;
        }
        return end-beg+1;
    }
    
    
 public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;
        
        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;
        
        return end - start + 1;
    }
