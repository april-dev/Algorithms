// a new test case has been added: [[-2147483646,-2147483645],[2147483646,2147483647]]. 
//This is because the result of subtraction is too large and thus overflow. So don't use a-b to compare when sorting. Use Integer.compare(a,b) instead

//sort by end point in ascending order
public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a, b)-> Integer.compare(a[1],b[1])); //avoid overflow
       // Arrays.sort(points, (a,b)-> a[1]-b[1]);
        
        int n = points.length;
        if (n==0) return 0;
        //int start = points[0][0];
        int end = points[0][1];
        int count = 1;
        for (int i=1; i<n; i++){
            if (points[i][0]>end){
                count++;
                //start = points[i][0];
                end = points[i][1];
            }
        }
        return count;
    }
    
    // sort by starting point in ascending order
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int count = 0;      // results
        // minEnd : Key parameter "active set" for overlapping intervals, 
        // e.g. the minimum ending point among all overlapping intervals;
        int minEnd = Integer.MAX_VALUE;
            
        Arrays.sort(points, (a, b)-> Integer.compare(a[0],b[0])); //avoid overflow
        //Arrays.sort(points, (a,b) -> (a[0] - b[0]));   // Sorting the intervals/pairs in ascending order of its starting point
            
        for (int[] in : points) {
            // If the changing some states, record some information, and start a new active set "new arrow"
            if (in[0] > minEnd) {
                count++;
                minEnd = in[1];
            } else {
                // renew key parameters of the active set
                minEnd = Math.min(minEnd, in[1]);
            }
        }
        return count + 1;
    }
