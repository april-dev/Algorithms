 public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int res = n+1;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] B = new int[n+1];
        for (int i=0; i<n; i++){
            B[i+1] = B[i] + A[i];
        }
        for (int i=0; i < n+1; i++){
            while(!deque.isEmpty() && B[i]-B[deque.getFirst()]>=K){
                res = Math.min(res, i-deque.pollFirst());
            }
            while(!deque.isEmpty() && B[i]<=B[deque.getLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res==n+1? -1:res;
    }
