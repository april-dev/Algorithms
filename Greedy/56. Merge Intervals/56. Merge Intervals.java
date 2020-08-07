public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]==b[0]?(a[1]-b[1]):(a[0]-b[0])));
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        if (intervals==null || n==0) return new int[n][];
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0]<=end){
                end = Math.max(intervals[i][1], end);
                
            }else{
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
               
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
    
    //improves memory
    public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
