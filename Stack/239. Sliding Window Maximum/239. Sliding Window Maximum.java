public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n==0) return nums;
        int[] res = new int[n-k+1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            if (!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offer(i);
            if (i >= k-1) res[i-k+1] = nums[dq.peek()];
        }
        return res;
    }
