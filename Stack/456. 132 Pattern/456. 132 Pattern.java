/*
s3 is actually 2 in the '132' pattern. what a confusing variable name.

Key:
1. update s3 as big as possible.
2. use a "sorted" stack to maintain the candidates of s2 and s3.
The numbers inside the stack are s2 and the number that popped out is the maximum s3.
*/

public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=nums.length-1; i>=0; i--){
            if (nums[i]<s3) return true;
            while (!stack.isEmpty() && nums[i]>stack.peek()){
                s3 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }


// O(N^3), TLE
public boolean find132pattern(int[] nums) {
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                for (int k=j+1; k<nums.length; k++){
                    if (nums[i]<nums[k] && nums[k]<nums[j]) return true;
                }
            }
        }
        return false;
    }

//O(N^2)
public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            if (min==nums[i]) continue;
            
            for (int j= nums.length-1; j>i; j--){
                if (min < nums[j] && nums[j] < nums[i]) return true;
            }
        }
        return false;
    }
