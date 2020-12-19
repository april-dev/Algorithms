//My solution 
//DP, similar to longest incresing subsequence
//O(N^2)
public boolean increasingTriplet(int[] nums) {
        if (nums.length<3) return false;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if (dp[i]>=3) return true;
        }
        return false;
    }
    
    
//better solution
//O(n)
/*
keep two values when check all elements in the array: the minimum value min until now and the second minimum value secondMin from the minimum value's position until now.
Then if we can find the third one that larger than those two values at the same time, it must exists the triplet subsequence and return true.
*/

public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
