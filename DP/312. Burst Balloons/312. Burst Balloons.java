/*
The subproblems are overlapped. So we can use divide and conquer + cache.

Balloons 0, 1, ..., n - 1
What is the max value if we burst all of them [0, n - 1]?
Let's first consider bursting [start, end]
Imagine we burst index i at the end
[start, ... i - 1, (i), i + 1 ... end]
Before the end, we already bursted [start, i - 1] and [i + 1, end]
Before the end, boundaries start - 1, i, end + 1 are always there
This helps us calculate coins without worrying about details inside [start, i - 1] and [i + 1, end]
So the range can be divided into
start - 1, maxCoin(start, i - 1), i, maxCoins(i + 1, end), end + 1
*/


public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        for (int i=0; i<newNums.length; i++){
            if (i==0 || i==n+1) newNums[i] = 1;
            else newNums[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for (int l=1; l<=n; l++){
            for (int i=1; i<=n-l+1; i++){
                int j = i+l-1;
                for (int k=i; k<=j; k++){
                    dp[i][j] = Math.max(dp[i][j], newNums[i-1]*newNums[k]*newNums[j+1]+dp[i][k-1]+dp[k+1][j]);
                }
            }
        }
        return dp[1][n];
    }
