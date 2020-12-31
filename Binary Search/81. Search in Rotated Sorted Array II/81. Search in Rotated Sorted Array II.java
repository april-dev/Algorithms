//Compare with Q33 (no duplicates)
//consider case [1,1,1,1,2,1], nums[left] == nums[mid] == nums[right], therefore will not pass the first for loop in Q33. 


//The idea is the same as the previous one without duplicates
/*
The only difference is that due to the existence of duplicates, we can have nums[left] == nums[mid] and in that case, 
the first half could be out of order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) and we have to deal this case separately. 
In that case, it is guaranteed that nums[right] also equals to nums[mid], so what we can do is to check if nums[mid]== nums[left] == nums[right] 
before the original logic, and if so, we can move left and right both towards the middle by 1. and repeat.
/*

public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
            }
            else if (nums[mid]<=nums[right]){
                if (target > nums[mid] && target <=nums[right]) left = mid + 1;
                else right = mid - 1;
                    
            }
            else{
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
                    
            }
        }
        return false;
    }




