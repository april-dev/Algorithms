public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l=0, r = n-1, peak = 0;
        while (l<r){
            int m = (l+r)/2;
            if (mountainArr.get(m)<mountainArr.get(m+1)) l=m+1;
            else r = m;
        }
        peak = l;
        l = 0;
        r = peak;
        while (l<=r){
            int m = (l+r)/2;
            if (mountainArr.get(m)< target) l = m+1;
            else if (mountainArr.get(m)> target) r = m-1;
            else return m;
        }
        l = peak;
        r = n-1;
        while (l<=r){
            int m = (l+r)/2;
             if (mountainArr.get(m)> target) l = m+1;
            else if (mountainArr.get(m)< target) r = m-1;
            else return m;
        }
        return -1;
    }
