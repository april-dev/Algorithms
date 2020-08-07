/*
A classic greedy case: interval scheduling problem.

The heuristic is: always pick the interval with the earliest end time. Then you can get the maximal number of non-overlapping intervals. (or minimal number to remove).
This is because, the interval with the earliest end time produces the maximal capacity to hold rest intervals.
E.g. Suppose current earliest end time of the rest intervals is x. Then available time slot left for other intervals is [x:]. 
If we choose another interval with end time y, then available time slot would be [y:]. Since x ≤ y, there is no way [y:] can hold more intervals then [x:]. 
Thus, the heuristic holds.
*/



//Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).
public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        if (intervals.length==0) return 0;
        int end = intervals[0][1];
        int count = 1;
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0]>=end){
                count+=1;
                end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
