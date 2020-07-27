//O(logN)
public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (A[mid]<A[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
    
   // O(n)
   public int peakIndexInMountainArray(int[] A) {
        for (int i=0; i<A.length-1; i++){
            if (A[i]>A[i+1]) return i;
        }
        return A.length-1;
    }
