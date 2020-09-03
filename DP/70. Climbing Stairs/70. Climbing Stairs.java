public int climbStairs(int n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int one_step_before = 2;
    int two_steps_before = 1;
    int all_ways = 0;
    
    for(int i=2; i<n; i++){
    	all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
        one_step_before = all_ways;
    }
    return all_ways;
}





public int climbStairs(int n) {
        int[] ans = new int[n];
        if (n==1) return 1;
        if (n==2) return 2;
        ans[0]=1;
        ans[1]=2;
        for (int i=2; i<n; i++){
            ans[i]=ans[i-1]+ans[i-2];
        }
        return ans[n-1];
    }
