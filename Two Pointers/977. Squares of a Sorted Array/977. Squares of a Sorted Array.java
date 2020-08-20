public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length-1;
        int[] res = new int[A.length];
        int idx = A.length-1;
        while (left<=right){
            if (Math.abs(A[left])<Math.abs(A[right])){
                
                res[idx] = A[right]*A[right];
                right--;
            }else{
                
                res[idx] = A[left]*A[left];
                left++;
            }      
            idx-=1;
        }
        return res;
    }
