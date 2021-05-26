//How to proof houses[(i + j) / 2] is better than (houses[i] + houses[j]) / 2 ?
//consider houses at 1, 99 and 100. In first you will put mailbox at 99 and in the other you will put at 50. Ofcourse the first one at 99 is optimal.
// If the number of items is odd, median guarantees the minimum, and if the number is even, any point between houses[(i+j)/2] and houses[(i+j)/2+1] is fine.
public int minDistance(int[] houses, int k) {
        int n = houses.length;
        int[][] costs = new int[n][n];
        Integer[][] memo = new Integer[k+1][n];
        Arrays.sort(houses);
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                for (int t=i; t<=j; t++){
                    costs[i][j] += Math.abs(houses[(i+j)/2] - houses[t]);
                }
            }
        }
       
        return dfs(costs, n, 0, k, memo);
    }
    public int dfs(int[][] costs, int n, int index, int k, Integer[][] memo){
        if (k==0 && index == n) return 0;
        if (k==0 || index==n) return Integer.MAX_VALUE;
        if (memo[k][index]!=null) return memo[k][index];
        int min = Integer.MAX_VALUE;
        for (int i=index; i<n; i++){
            int next = dfs(costs, n, i+1, k-1, memo);
            if (next!=Integer.MAX_VALUE) min = Math.min(min, costs[index][i] + next);
        }
        memo[k][index] = min;
        return min;
    }
