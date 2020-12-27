public int eatenApples(int[] apples, int[] days) {
        int res = 0;
        int n = apples.length;        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        
        for (int i=0; i<n || !pq.isEmpty(); i++){
            if (i<n) pq.offer(new int[]{apples[i], i + days[i]});
            
            while (!pq.isEmpty() && pq.peek()[1] <= i) pq.poll();
            
            if (!pq.isEmpty()){
                res++;
                pq.peek()[0]--;
                if (pq.peek()[0] == 0) pq.poll();
            }
        }
        return res;
    }
