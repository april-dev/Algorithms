public int searchInsert(int[] nums, int target) {
        
        int l=0, r = nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if (nums[m]==target){
                return m;
            }else if (nums[m]<target){
                l = m+1;
            }else{
                r=m-1;
            }
        }
        return l;
}

//this solution wont pass [1,3,5,7], target is 2.
public int searchInsert(int[] nums, int target) {
 int l=0, r = nums.length-1;
        while (l<r){
            int m = (l+r+1)/2;
            if (nums[m]>target){
                r=m-1;
            
            }else{
                l=m;
            }
        }
        return l;
}

//careful:r is set to nums.length without -1. other wise wont pass [1,3,5,7], target is 8.
int l=0, r = nums.length;
        while (l<r){
            int m = (l+r)/2;
            if (nums[m]<target){
                l=m+1;
            
            }else{
                r=m;
            }
        }
        return l;
