public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m*n;
        while (left<right){
            int mid = left + (right - left)/2;
            int count = 0;
            for (int i=1; i<=m; i++){
                int temp = Math.min(mid/i, n);
                count += temp;
            }
            if (count<k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
