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
