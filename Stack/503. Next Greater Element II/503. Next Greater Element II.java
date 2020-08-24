public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i=0; i<n*2; i++){
            int num = nums[i%n];
            while(!stack.isEmpty()&& nums[stack.peek()]<num){
                int idx = stack.pop();
                res[idx] = num;
            }
            if (i<n) stack.push(i);
        }
        return res;
    }
