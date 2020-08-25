// can also use count of greater elements. See notes.

public int sumSubarrayMins(int[] A) {
        Stack<Integer> previous = new Stack<>();
        Stack<Integer> next = new Stack<>();
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i = 0; i < n; i++) {
            left[i] = i + 1;
            right[i] = n - i;
        }  
        
        for (int i=0; i<n; i++){
            while (!previous.isEmpty() && A[previous.peek()]>A[i]){
                previous.pop();
            }
            left[i] = previous.isEmpty()? i+1:i-previous.peek();
            previous.push(i);
        }
        
        for (int i=0; i<n; i++){
            while (!next.isEmpty() && A[next.peek()]>A[i]){
                int idx = next.pop();
                right[idx]=i-idx;
            }
            next.push(i);
        }
        
        int res = 0, mod = (int) 1e9 +7;
        for (int i=0; i<n; i++){
            res = (res + A[i]*left[i]*right[i])%mod;
        }
        return res;
    }
