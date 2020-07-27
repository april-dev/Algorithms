/*
Lets say you have a mid number at index x, nums[x]
if (num[x+1] > nums[x]), that means a peak element HAS to exist on the right half of that array, because (since every number is unique) 
1. the numbers keep increasing on the right side, and the peak will be the last element. 
2. the numbers stop increasing and there is a 'dip', or there exists somewhere a number such that nums[y] < nums[y-1], which means number[y] is a peak element.

This same logic can be applied to the left hand side (nums[x] < nums[x-1]).

*/

/*
Let D stands for the derivative, we konw that D(-1)>0, D(n-1)<0. 
If D(mid-1) < 0, there must be a value x between [low, mid-1] for that from left to right of it , D>0 becomes D<0.
*/

public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]<nums[mid+1]){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
