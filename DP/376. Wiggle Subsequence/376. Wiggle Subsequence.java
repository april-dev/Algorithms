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
    
    //save space (also a greedy solution)
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

//Greedy
public int wiggleMaxLength(int[] nums) {
    if(nums.length == 0) return 0;
    int count = 1;
    int prevDiff = 0;
    for (int i = 1; i < nums.length; i++) {
        int diff = nums[i] - nums[i-1];
        if( (diff > 0 && prevDiff <= 0) ||
             (diff < 0 && prevDiff >=0) ) {
            count++;
            prevDiff = diff;
        }
    }
    return count;
}
    
//O(N^2) solution
//similar to longest increasing subsequence
//however, For each i, we do not need to compare all the previous conditions and update the max, cuz for both up and down array, 
//its length keeps increasing(+0 or +1) with either copying from last element or plus 1 operation.
//And, if we reduce the space to O(1). It would be the exactly same as the most up-voted greedy solution.

//similar to waves, pick up turning point at very local max or min.

public int wiggleMaxLength(int[] nums) {
        if (nums.length==0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        int res = 1;
        for (int i=1; i<nums.length; ++i){
            for (int j=0; j<i; ++j){
                if(nums[j]<nums[i]){
                    up[i] = Math.max(up[i], down[j]+1);
                }else if (nums[j]>nums[i]){
                    down[i] = Math.max(down[i], up[j]+1);
                }
            }
            int max = Math.max(up[i], down[i]);
            res = Math.max(res, max);
        }
        return res;
    }
