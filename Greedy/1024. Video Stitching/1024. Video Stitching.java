//Greedy
//Time O(NlogN)
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


//DP 
//Time O(NT)
public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.fill(dp, T+1);
        dp[0] = 0;
        for (int i=0; i<=T; i++){
            for (int[] clip:clips){
                if (clip[0]<=i && i<=clip[1]){
                    dp[i] = Math.min(dp[i], dp[clip[0]]+1);
                }
            }
            if (dp[i]==T+1) return -1;
        }
        return dp[T];
    }

//DP
//Time complexity: O(nT^2)
//https://zxi.mytechroad.com/blog/leetcode/leetcode-weekly-contest-131-1021-1022-1023-1024/
public:
  int videoStitching(vector<vector<int>>& clips, int T) {
    constexpr int kInf = 101;
    // dp[i][j] := min clips to cover range [i, j]
    vector<vector<int>> dp(T + 1, vector<int>(T + 1, kInf));   
    for (const auto& c : clips) {
      int s = c[0];
      int e = c[1];
      for (int l = 1; l <= T; ++l) {
        for (int i = 0; i <= T - l; ++i) {
          int j = i + l;
          if (s > j || e < i) continue;
          if (s <= i && e >= j) dp[i][j] = 1;
          else if (e >= j) dp[i][j] = min(dp[i][j], dp[i][s] + 1);
          else if (s <= i) dp[i][j] = min(dp[i][j], dp[e][j] + 1);
          else dp[i][j] = min(dp[i][j], dp[i][s] + 1 + dp[e][j]);          
        }
      }
    }
    return dp[0][T] == kInf ? -1 : dp[0][T];
  }
