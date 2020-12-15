//dont need to track turns, because for Alice, max the difference, for Bob, min the difference, but since Bob always lose, he will have a negative difference
//so max the negative difference equals min the difference
class Solution {
    public int stoneGameVII(int[] stones) {
        int sum = 0;
        for (int stone: stones) sum += stone;
        int[][] dp = new int[stones.length][stones.length];
        return helper(stones, 0, stones.length-1, sum, dp);
    }
    public int helper(int[] stones, int i, int j, int sum, int[][] dp){
        if (i == j) return 0;
        if (dp[i][j]!=0) return dp[i][j];
        int left = sum - stones[i] - helper(stones, i+1, j, sum - stones[i], dp);
        int right = sum - stones[j] - helper(stones, i, j-1, sum - stones[j], dp);
        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }
}
