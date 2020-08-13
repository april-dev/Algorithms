public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<Integer>();
        helper(S, res, 0);
        return res;
    }
        
        public boolean helper(String S, List<Integer> res, int index) {
            if (index == S.length() && res.size()>=3) return true;
                   
            for (int i=index; i<S.length(); i++){
                if (S.charAt(index) == '0' && i>index) break;
                
                long num = Long.parseLong(S.substring(index, i+1));
                if (num > Integer.MAX_VALUE) break;
                
                int size = res.size();              
                if (size >= 2 && num > res.get(size-1)+res.get(size-2)) break;
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (size<=1 || num == res.get(size-1)+res.get(size-2)){
                    res.add((int)num);
                    if(helper(S, res, i+1)) return true;
                    res.remove(res.size()-1);
                }
            }
            return false;
        }
