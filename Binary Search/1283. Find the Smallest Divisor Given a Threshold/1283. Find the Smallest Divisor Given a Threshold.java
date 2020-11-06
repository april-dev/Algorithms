//My solution
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000;
        
        while (left<right){
            int mid = left + (right - left)/2;
            if (helper(nums, mid)>threshold){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public int helper(int[] nums, int mid){
        int res = 0;
        for (int num:nums){
            if (num%mid!=0) res = res + num/mid +1;
            else res = res + num/mid;
        }
        return res;
    }
}

//ceil(x) = int(x + 0.9999), so add (m-1)/m
//can also think of (i+m-1)/m as ((i-1)/m) + 1 
public int smallestDivisor(int[] A, int threshold) {
        int left = 1, right = (int)1e6;
        while (left < right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : A)
                sum += (i + m - 1) / m;
            if (sum > threshold)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }

public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1, right = (int)1e6;
 
        while (left<right){
            int mid = left + (right - left)/2;
            int sum = 0;
            for (int num:nums){
                //sum+= (num+mid-1)/mid;
                sum+= (int) Math.ceil((float)num/mid);
            }
            if (sum>threshold){
                left = mid+1;
            }else{
                 right = mid;
            }
        }
        return left;
    }
