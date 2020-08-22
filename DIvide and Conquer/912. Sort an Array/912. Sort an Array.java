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

//Heap sort
public int[] sortArray(int[] nums) {
        for (int i=nums.length/2-1; i>=0; i--){
            heapify(nums, i, nums.length-1);
        }
        for (int i=nums.length-1; i>=1; i--){
            swap(nums, 0, i);
            heapify(nums, 0, i-1);
        }
        return nums;
    }
    
    public void heapify(int[] nums, int i, int end){
        while (i<=end){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int maxIdx = i;
            if (left<=end && nums[left]>nums[maxIdx]) maxIdx = left;
            if (right<=end && nums[right]>nums[maxIdx]) maxIdx = right;
            if (maxIdx==i) break;
            swap(nums, i, maxIdx);
            i = maxIdx;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//Top down merge sort
public int[] sortArray(int[] nums) {
        sort(nums, 0 , nums.length-1);
        return nums;
    }
    
    public void sort(int[] nums, int l, int r){
        if (l>=r) return;
        int mid = l+ (r-l)/2;
        sort(nums, l, mid);
        sort(nums, mid+1, r);
        merge(nums, l,mid,r);    
    }
    public void merge(int[] nums, int l, int m, int r){
        int[] temp = new int[r-l+1];
        int i=l, j=m+1;
        int k=0;
        while (i<=m && j<=r){
            if (nums[i]<nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            }else{
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        while (i<=m){
            temp[k] = nums[i];
                k++;
                i++;
        }
        while (j<=r){
            temp[k] = nums[j];
                k++;
                j++;
        }
        for (int p=l, q=0; p<=r; p++, q++){
            nums[p] = temp[q];
        }
    }
