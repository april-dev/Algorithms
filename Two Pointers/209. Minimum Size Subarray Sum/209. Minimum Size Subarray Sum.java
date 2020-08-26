public int minSubArrayLen(int s, int[] nums) {
        int i=0, j=0;
        int curSum = 0;
        int maxLen = Integer.MAX_VALUE;
        while (j<nums.length){
            curSum+=nums[j];
            while (curSum>=s) {
                maxLen = Math.min(maxLen, j-i+1);
                curSum -= nums[i];
                i++;
            }
            j++;
        }
        return maxLen==Integer.MAX_VALUE?0:maxLen;
    }
