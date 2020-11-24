class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<input.length(); i++){
            if (input.charAt(i)=='*' || input.charAt(i)=='-' || input.charAt(i)=='+'){
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> leftSet = diffWaysToCompute(left);
                List<Integer> rightSet = diffWaysToCompute(right);
                for (int p1:leftSet){
                    for (int p2:rightSet){
                        int c = 0;
                        switch (input.charAt(i)){
                            case '+': c = p1 + p2;
                                break;
                            case '-': c = p1 - p2;
                                break;
                            case '*': c = p1 * p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size()==0) ret.add(Integer.valueOf(input));
        return ret;
    }
}
