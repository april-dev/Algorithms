
//Time complexity: O(2^n)
//Space complexity: O(2^n)
public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        
        for (int i=0; i<n; i++){
            int resSize = res.size();
            for (int k=resSize-1; k>=0; k--){
                res.add(res.get(k) | 1 << i);
            }
        }
        return res;
    }
