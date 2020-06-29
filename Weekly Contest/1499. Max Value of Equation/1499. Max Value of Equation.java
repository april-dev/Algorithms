
//Priority queue
//O(nlogn)

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> (b[1] - b[0] - (a[1] - a[0])));
        for (int[] p:points){
            while (!q.isEmpty() && p[0]-q.peek()[0]>k) q.poll();
            if (!q.isEmpty()) {
                int[] head = q.peek();
                res = Math.max(res, p[1]+p[0]+head[1]-head[0]);
             }
            q.offer(p);
        }
        return res;
    }
}

//mono deque
//O(n)

       Deque<Integer> dq = new ArrayDeque<>();
        int n = ps.length, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && ps[i][0] - ps[dq.peekFirst()][0] > k) dq.pollFirst();
            if (!dq.isEmpty()) {
                int j = dq.peekFirst();
                res = Math.max(res, ps[i][1] + ps[j][1] + ps[i][0] - ps[j][0]);
            }
            while (!dq.isEmpty() && ps[i][1] - ps[i][0] >= ps[dq.peekLast()][1] - ps[dq.peekLast()][0]) dq.pollLast();
            dq.offerLast(i);
        }
        return res;
