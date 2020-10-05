//Greedy
public int videoStitching(int[][] clips, int T) {
        int n = clips.length;
        int[] maxes = new int[101];
        Arrays.sort(clips, (a,b)->(a[0]==b[0]? a[1]-b[1]:a[0]-b[0]));
        for (int[] clip:clips){
            maxes[clip[0]] = clip[1];
        }
        if (maxes[0]==0) return -1;
        
        int count = 1;
        int start = 0, end = maxes[0];
        while (start < T && end < T){
            int max = 0, maxIndex = -1;
            for (int j=end; j>start; j--){
                if (maxes[j]>max){
                    max = maxes[j];
                    maxIndex = j;
                }
            }
            if (maxIndex==-1 || max<=end) return -1;
            count++;
            start = maxIndex;
            end = maxes[start];
        }
        return count;
    }
