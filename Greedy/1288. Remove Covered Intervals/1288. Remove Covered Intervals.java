public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0] == b[0]? b[1]-a[1]:a[0]-b[0]);
        int[] cur = intervals[0];
        int total = n;
        for(int i = 1; i < n; ++i){             
            if(cur[1] >= intervals[i][1]){     
                --total;                      
            }                                  
            else{                              
                cur = intervals[i];             
            }                                   
        }                                    
        return total;                          
    } 
