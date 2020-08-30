//brute force
public boolean containsPattern(int[] arr, int m, int k) {
        //HashMap<String, Integer> map = new HashMap<>();
        if (m*k > arr.length) return false;
        
        for (int i=0; i<arr.length-m*k+1; i++){
            int[] temp = new int[m];
            for (int j=0; j<m; j++){
                temp[j] = arr[i+j];
            }
            
            if (check(temp, arr, i, k, m)) return true;
        }
        return false;
    }
    public boolean check(int[] temp, int[] arr, int s, int k, int m){
        int c = 0;
        while (c<m*k){
            for (int i=0; i<temp.length; i++){
                if (arr[c+s+i]!=temp[i]) return false;
            }
            c+=m;
        }
        return true;
    }
    
    //Simple
    public boolean containsPattern(int[] arr, int m, int k) {
        int cnt = 0;
        for (int i=0; i<arr.length-m; i++){
            if (arr[i]!=arr[i+m]){
                cnt = 0;
            }else{
                cnt+=1;
            }
            if (cnt==m*(k-1)) return true;
            
        }
        return false;
    }
