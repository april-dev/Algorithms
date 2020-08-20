public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0]+nums[1]+nums[2];
        
        Arrays.sort(nums);
        
        for (int i=0; i<n-2; i++){
            int lo = i+1, high = n-1;     
            while (lo<high){
                int sum = nums[i]+nums[lo]+nums[high];
                if (Math.abs(sum-target)<Math.abs(ans-target)) ans = sum;
                
                if (sum<target) lo++;
                else if (sum>target) high--;
                else return sum;            
            } 
        }
        return ans;
    }
