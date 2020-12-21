//DP + stack
//similar to 239. Sliding Window Maximum
//first attemp: O(N^2), TLE

public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        
        LinkedList<Integer> dq = new LinkedList<>();
        dq.add(0);
        for (int i=1; i<nums.length; i++){
            int max = dp[dq.peek()];        
            dp[i] = max+nums[i];
            if (!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) dq.pollLast();           
            dq.offer(i);           
        }
        return dp[nums.length-1];
    }


//Small improvement
// i start from 0 in the for loop
public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        
        LinkedList<Integer> dq = new LinkedList<>();
       // dq.add(0);
        for (int i=0; i<nums.length; i++){
            int max = dq.isEmpty()? 0 : dp[dq.peek()];        
            dp[i] = max+nums[i];
            if (!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) dq.pollLast();           
            dq.offer(i);           
        }
        return dp[nums.length-1];
    }
