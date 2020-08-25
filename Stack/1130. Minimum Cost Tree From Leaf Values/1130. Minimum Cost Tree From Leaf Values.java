public int mctFromLeafValues(int[] A) {
        Stack<Integer> stack = new Stack<>();
       stack.add(Integer.MAX_VALUE);
       int res = 0;
       for (int a:A){
           while (!stack.isEmpty() && stack.peek()<a){
               int mid = stack.pop();
               res += mid*Math.min(a, stack.peek());
           }
           stack.push(a);
       }
       while (stack.size()>2){
           res += stack.pop()*stack.peek();
       }
       return res;
    }
    
    //Greedy O(N^2)
    class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        res = 0
        while len(arr) > 1:
            index = arr.index(min(arr))
            if 0 < index < len(arr) - 1:
                res += arr[index] * min(arr[index - 1], arr[index + 1])
            else:
                res += arr[index] * (arr[index + 1] if index == 0 else arr[index - 1])
            arr.pop(index)
        return res
        
    //DP
    //Top down
     public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return dfs(arr, 0, n - 1, dp);
    }
    
    public int dfs(int[] arr, int s, int e, int[][] dp) {
        if (s == e) return 0;
        if (dp[s][e] > 0) return dp[s][e];
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int left = dfs(arr, s, i, dp);
            int right = dfs(arr, i + 1, e, dp);
            int maxLeft = 0, maxRight = 0;
            for (int j = s; j <= i; j++) maxLeft = Math.max(maxLeft, arr[j]);
            for (int j = i + 1; j <= e; j++) maxRight = Math.max(maxRight, arr[j]);
            ans = Math.min(ans, left + right + maxLeft * maxRight);
        }
        dp[s][e] = ans;
        return ans;
    }
    
    
//Bottom up
class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        n = len(arr)
        dp = [[float('inf') for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = 0
        
        for l in range(2, n + 1):
            for i in range(n - l + 1):
                j = i + l - 1
                for k in range(i, j):
                    rootVal = max(arr[i:k+1]) * max(arr[k+1:j+1])
                    dp[i][j] = min(dp[i][j], rootVal + dp[i][k] + dp[k + 1][j])
        return dp[0][n - 1]
