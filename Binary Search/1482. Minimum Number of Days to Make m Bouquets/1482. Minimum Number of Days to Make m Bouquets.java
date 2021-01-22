public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = 1000000000;
        if (m * k > bloomDay.length) return -1;
        while (left < right){
            int mid = left + (right - left)/2;
            int bouquet = 0, count = 0;
            for (int b: bloomDay){
                if (b<=mid){
                    count++;
                    if (count==k) {
                        bouquet++;
                        count = 0;
                    }
                }else{
                    count = 0;
                }
            }
            if (bouquet < m) left = mid+1;
            else right = mid;
                
        }
        return left;
    }
