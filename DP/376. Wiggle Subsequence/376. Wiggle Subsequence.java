public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        int[] up = new int[n], down = new int[n];
        up[0] = 1;
        down[0] = 1;
        
        for (int i=1; i<n; i++){
            if (nums[i]-nums[i-1]>0){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if (nums[i]-nums[i-1]<0){
                up[i] = up[i-1];
                down[i] = up[i-1]+1;
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1], down[n-1]);
    }
    
    //save space
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        int up = 1, down = 1;
        
        for (int i=1; i<n; i++){
            if (nums[i]-nums[i-1]>0){
                up = down+1;
            }else if (nums[i]-nums[i-1]<0){
                down = up+1;
            }
        }
        return Math.max(up, down);
    }
    
