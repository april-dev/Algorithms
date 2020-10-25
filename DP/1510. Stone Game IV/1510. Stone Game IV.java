/*
dp[i] = true represents that for i th number, Alice can win. False means Alice loses.
Lets assume Alice loses for n=j.
Thus, if at any point i Alice can remove a square number such that the remaining number is equal to j, and j is false, then Alice can win at the point i.
*/

//Time: O(n*sqrt(n))
public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for (int i=1; i<=n; i++){
            for (int k=1; k*k<=i; k++){
                if (dp[i-k*k]==false){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
