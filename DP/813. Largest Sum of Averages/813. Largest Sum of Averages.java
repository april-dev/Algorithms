//https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-813-largest-sum-of-averages/
public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[K+1][A.length+1];
        int[] sums = new int[A.length+1];
        for (int i=1; i<=A.length; i++) {
            sums[i] = A[i-1] + sums[i-1];
            dp[1][i] = (double)sums[i]/i;
        }
        for (int k=2; k<=K; k++){
            for (int i=k; i<=A.length; i++){
                for (int j=k-1; j<i; j++){
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (double)(sums[i] - sums[j]) / (i - j));
                }
            }
        }
        return dp[K][A.length];
    }  

class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[K+1][n+1];
        int[] sums = new int[n+1];
        for (int i=1; i<=n; i++) sums[i] = A[i-1] + sums[i-1];
        return helper(sums, A, K, n, dp);
    } 
    public double helper(int[] sums, int[] A, int K, int n, double[][] dp){
        if (dp[K][n]>0) return dp[K][n];
        if (K==1) return (double)sums[n]/n;
        for (int i=K-1; i<n; i++){
            dp[K][n] = Math.max(dp[K][n], helper(sums, A, K-1, i, dp)+1.0*(sums[n]-sums[i])/(n-i));
        }
        return dp[K][n];
    }
}
