    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length, res=0, l=0, r=n-1,  mod = (int)1e9 + 7;
        int[] pow = new int[n];
        pow[0]=1;
        for (int i=1; i<nums.length; i++){
            pow[i] = pow[i-1] * 2 % mod;
        }
        while (l<=r){
            if (nums[l]+nums[r]>target){
                r-=1;
            }else{
                res = (res + pow[r-l])%mod;
                l+=1;
            }
        }
        return res;
    }
