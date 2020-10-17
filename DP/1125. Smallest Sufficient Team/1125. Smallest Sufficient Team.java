//Time: O(people.size * 2^n)

public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int ppl = people.size();
            
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) map.put(req_skills[i], i);
        
        int[][] dp = new int[ppl+1][1<<n];
        int[][] path = new int[1<<n][2];

        Arrays.fill(dp[0], Integer.MAX_VALUE/2);
        dp[0][0] = 0;

        for (int i=1; i<=people.size(); i++){
            int k = 0;
            for (String s:people.get(i-1)) k |= (1<<map.get(s));
            dp[i] = dp[i-1];
            for (int j=0; j<(1<<n); j++){
                    if ( dp[i-1][j] + 1<dp[i][j | k]) {
                        dp[i][j | k] =  dp[i-1][j] + 1;
                        path[j | k][0] = j;
                        path[j | k][1] = i;
                    }
            }
        }
            
        int target = (1<<n) - 1;
        Stack<Integer> stack = new Stack<>();
        while (target>0){
            stack.add(path[target][1]-1);
            target = path[target][0];
        }
            
        int[] res = new int[stack.size()];
        for (int i=0; i<res.length; i++){
            res[i] = stack.pop();
        }
        return res;
    }
