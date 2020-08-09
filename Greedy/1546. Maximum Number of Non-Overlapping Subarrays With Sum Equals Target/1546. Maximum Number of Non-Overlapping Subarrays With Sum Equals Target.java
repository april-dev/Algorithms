//use index as value of the hashmap
public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        int prefixSum=0, availableIdx=-1, res=0;
        map.put(0,-1);
        for (int i=0; i<nums.length; i++){
            prefixSum+=nums[i];
            int remain = prefixSum - target;
            if (map.containsKey(remain) && map.get(remain)>=availableIdx){
                res++;
                availableIdx=i;
            }
            map.put(prefixSum, i);
        }
        return res;
    }
    
    
 //Use count as value of the hashmap   
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 0);

int res = 0;
int sum = 0;

for (int i = 0; i < nums.length; ++i) {
	sum += nums[i];
	if (map.containsKey(sum - target)) {
		res = Math.max(res, map.get(sum - target) + 1);
	}
	map.put(sum, res);
}

return res;

//DP solution: runtime slow O(N^2);
int N = nums.length;
int[] dp = new int[N + 1];

for (int i = 0; i < N; ++i) {

	int sum = 0;
	for (int j = i; j >= 0; --j) {
		sum += nums[j];
		dp[i + 1] = Math.max(dp[i + 1], dp[j] + (sum == target ? 1 : 0));
	}
}

return dp[N];
