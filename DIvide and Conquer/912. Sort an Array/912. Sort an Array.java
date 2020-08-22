//Bubble sort O(N^2)
public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++){
            for (int j=0; j<n-1; j++){
                if (nums[j]>nums[j+1]){
                //swap(nums, j, j + 1);
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    
 //Insertion sort;
 public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i=1; i<n; i++){
            for (int j=i; j>=1; j--){
                if (nums[j]>=nums[j-1]) break;
                if (nums[j]<nums[j-1]){
                //swap(nums, j, j - 1);
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return nums;
    }

//Selection sort
public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++){
            int min = i;
            for (int j=i+1; j<n; j++){
                if (nums[j]<nums[min]){
                    min = j;
                }
                
            }
            if (min!=i){
                //swap(nums, i, min)
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }
