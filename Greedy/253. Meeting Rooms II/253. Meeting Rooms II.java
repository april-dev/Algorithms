/*
What the algorithm is doing is checking how many meetings begin before the earliest-ended meeting ends. 
If, for instance, 3 meetings have started before the earliest possible meeting end, than we need 3 rooms. 
Sorting the arrays helps in two things: first of all you can easily get the earliest meetings end time, and secondly,
it allows you to start looking for meetings ends only from next element in the ends array when you find some meeting start that is after the current end, 
because all other meeting ends before the current in the sorted array will also be before the current meeting start. So you just have to run 1 time over each array.
*/
public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i=0; i<n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endPos = 0;
        int rooms = 0;
        for (int i=0; i<n; i++){
            if (start[i]<end[endPos]){
                rooms++;
            }else{
                endPos++;
            }
        }
        return rooms;
    }
