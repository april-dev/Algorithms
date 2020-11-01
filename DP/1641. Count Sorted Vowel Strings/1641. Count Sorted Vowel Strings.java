 //My solution
 //map stores strings end with these vowels
    public int countVowelStrings(int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        for (int i=2; i<=n; i++) {   
            map.put('u', map.get('a') + map.get('e') + map.get('i') + map.get('o') + map.get('u'));
            map.put('o', map.get('a') + map.get('e') + map.get('i') + map.get('o'));
            map.put('i', map.get('a') + map.get('e') + map.get('i'));
            map.put('e', map.get('a') + map.get('e'));
        }
        int res = 0;
        for (Character key:map.keySet()){
            res += map.get(key);
        }
        return res;
    }
    //concise version
     public int countVowelStrings(int n) {
         int[] count = new int[5];
         Arrays.fill(count, 1);
         for (int i=2; i<=n; i++){
             for (int j=4; j>=0; j--){
                 for (int p=j-1; p>=0; p--){
                     count[j] += count[p];
                 }
             }
         }
         int res = 0;
         for (int i=0; i<5; i++) res += count[i];
         return res;
     }
     
     //DP
     //https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918760/Dynamic-Programming-Python-100-Explanation-%2B-code
      def countVowelStrings(self, n: int) -> int:
        dp = [[i for i in range(5,0,-1)] for _ in range(n)]   # intialize dp matrix
        
        for i in range(1,n):
            for j in range(3,-1,-1):
                dp[i][j] = dp[i - 1][j] + dp[i][j + 1]   # dp expression
                
        return dp[n-1][0]
