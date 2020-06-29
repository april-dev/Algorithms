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
