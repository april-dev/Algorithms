public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] candidate = new int[n][2];
        int[] dp = new int[n];
        int res = 0;
        for (int i=0; i<scores.length; i++){
            candidate[i][0] = ages[i];
            candidate[i][1] = scores[i];          
        }
        Arrays.sort(candidate, (a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        
        for (int i=0; i<n; i++){
            dp[i] = candidate[i][1];
            for (int j=0; j<i; j++){
                if (candidate[j][1]<=candidate[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+candidate[i][1]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
