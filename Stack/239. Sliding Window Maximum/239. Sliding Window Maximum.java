public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || k<=0 ) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int ri = 0;
        for (int i=0; i<n; i++){
            if (!deque.isEmpty() && deque.peek()<i-k+1) deque.poll();
            while (!deque.isEmpty() &&  nums[i]>nums[deque.peekLast()]) deque.pollLast();
            deque.offer(i);
            if (i>=k-1) {
                res[ri] = nums[deque.peek()];
                ri+=1;
            }
        }
        return res;    
    }
