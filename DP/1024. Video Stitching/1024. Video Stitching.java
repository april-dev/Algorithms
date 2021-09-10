public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time+1];
        Arrays.sort(clips, (a,b)->a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        Arrays.fill(dp, time+1);
        dp[0] = 0;
        for (int i=0; i<clips.length; i++){
            int start = clips[i][0];
            int end = clips[i][1];
            for (int j=start+1; j<=Math.min(end, time); j++){
                dp[j] = Math.min(dp[j], dp[start]+1);
            }
        }
        return dp[time]==time+1?-1: dp[time];
    }
