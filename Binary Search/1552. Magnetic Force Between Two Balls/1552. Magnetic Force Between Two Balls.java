 
//Time complexity: O(Nlog(10^9)) or O(NlogM), where M = max(position) - min(position)


public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left=0, right = position[n-1]-position[0];
        while(left<right){
         //As a rule of thumb, use m = l + (r-l)//2 with l = m + 1 and r = m, 
         //and use m = r - (r-l)//2 with l = m and r = m - 1. This can prevent m from stucking at r (or l) after the updating step.
            int mid = left + (right-left+1)/2;
            int start = position[0];
            int count = 1;
            for (int i=1; i<n; i++){
                if (position[i]-start>=mid){
                    count+=1;
                    start = position[i];
                }
            }
            if (count<m){
                right = mid-1;;
            }else{
                left = mid;
            }
        }
        return left;
    }
