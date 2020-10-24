public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0, i=0, j=tokens.length-1;
       
       while (i<=j){
            if (tokens[i]<=P){
                P-= tokens[i++];
                score++;
                maxScore = Math.max(score, maxScore);
            }else if (score > 0){
                P += tokens[j--];
                score--;
            }else{
                break;
            }          
        }
        return maxScore;
    }
