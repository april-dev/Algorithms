public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -x;
        for (int num:nums) target += num;
        if (target ==0) return nums.length;
        int sum = 0;
        map.put(0, -1);
        int res = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];
            if (map.containsKey(sum-target)){
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return res==Integer.MIN_VALUE?-1:nums.length - res;
    }
