public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int res = 0;
        map.put(0, 1);
        for (int cur:nums){
            prefixSum += cur;
            if (map.containsKey(prefixSum-k)){
                res+=map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        
        return res;    
    }
    
 //Brute force O(N^3)
 public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int x=0; x < nums.length; x++){
            for(int y=x; y < nums.length; y++){
                int sum = 0;
                for(int z=x; z <= y; z++)
                    sum += nums[z];
                if(sum == k)
                    ++count;
            }
        }
        return count;
    }
    
 //make use of prefix sum for the third for-loop above. 
 public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int x=1; x < nums.length; x++)
            nums[x] += nums[x-1];
        for(int x=0; x < nums.length; x++){
            if(nums[x] == k)
                ++count;
            for(int y=x+1; y < nums.length; y++)
                if(nums[y]-nums[x] == k)
                    ++count;
        }
        return count;
    }
 
 
