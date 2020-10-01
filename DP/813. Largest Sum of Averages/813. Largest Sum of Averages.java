//https://leetcode.com/problems/largest-sum-of-averages/discuss/126280/Naive-Detailed-Step-by-Step-Approach-from-Recursive-to-DP-O(N)-solution
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length][K+1];
        int[] sum = new int[A.length];
        for (int i=0; i<A.length; i++) {
            sum[i] = A[i] + (i>0?sum[i-1]:0);       
        }
        return helper(A, K, dp, 0, sum);
    }
    public double helper(int[] A, int K, double[][] dp, int idx, int[] sum){
        if (dp[idx][K]!=0) return dp[idx][K];
        
        if (K == 1){
            dp[idx][K] = ((double)(sum[A.length-1] - sum[idx] + A[idx]) / (A.length-idx));
            return dp[idx][K];
        }
        
        for (int i=idx; i+K<=A.length; i++){
            dp[idx][K] = Math.max(dp[idx][K], ((double)(sum[i]-sum[idx]+A[idx])/(i-idx+1)) + helper(A, K-1, dp, i+1, sum));
            }
        return dp[idx][K];
    }    
}

/*
First, we should compute the sum array, which will be helpful when we compute mean value of subarray.
Just like, if we want to compute mean of subarray A[i] ~ A[j], we can use sum[j + 1] - sum[i] / (j + 1 - i).(There we use sum[i] represent the front i's element of A's sum).
Then we simply judge the special case,if K <= 1, we just compute the overall mean, if K >= n, we just return total sum as every single element be a subarray.
Then, we start to construct the dp vector.

dp[i][1] represent the largest sum of averages of front i's element in A when K = 1, namely the mean of subarray A[0] ~A[i - 1].

dp[i][k] = max(dp[i][k], dp[j][k - 1] + 1.0 * (sum[i] - sum[j]) / (i - j)) means we split the k subarray to k -1 subarray in A[0] ~A[j - 1] and 
one more subarray from A[j] ~A[i - 1], use the sum we already computed, we can get this subarray's mean easily.

Finally, we got the answer dp[n][K], so the total time complexity is O(K*n^2), and the total space complexity is O(n * K).
*/
class Solution {
public:
    double largestSumOfAverages(vector<int>& A, int K) {
        int n = A.size();
        vector<int> sum(n + 1, 0);
        for(int i = 0; i < n; ++i){
        	sum[i + 1] = sum[i] + A[i];
        }
        if(K <= 1){
        	return (1.0 * sum[n]) / n;
        }
        if(K >= n){
        	return sum[n];
        }
        vector<vector<double>> dp(n + 1, vector<double>(K + 1, 0.0));
        for(int i = 1; i <= n; ++i){
        	dp[i][1] = (1.0 * sum[i]) / i;
        }
        for(int k = 2; k <= K; ++k){
        	for(int i = k; i <= n; ++i){
        		for(int j = i - 1; j >= k - 1; --j){
        			dp[i][k] = max(dp[i][k], dp[j][k - 1] + 1.0 * (sum[i] - sum[j]) / (i - j));
        		}
        		
        	}
        }
        return dp[n][K];
    }
};
