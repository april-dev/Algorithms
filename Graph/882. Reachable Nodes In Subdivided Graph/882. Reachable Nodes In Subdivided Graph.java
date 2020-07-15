   /* 
main problem: how to avoid duplications when counting the intermediate nodes (new nodes between original nodes)?
let say we have 5 nodes between i and j: i - x1 - x2 - x3 - x4 - x5 - j
we come to i with 3 remaining moves and j through another path with 4 remaining moves.
from i we can go to x3, and from j we can go to x2, in total we can visit all 5 nodes between i and j
this is where the used comes into play: used[i][j] is the maximum nodes we can go from i to j and used[j][i] is the reversed
number of nodes can visit between i, j is: min(edges[i][j], used[i][j] + used[j][i])
*/
/*
Reason why priority queue is used instead of queue. consider test case:
{{0,3,8},{0,1,4},{2,4,3},{1,2,0},{1,3,9},{0,4,7},{3,4,9},{1,4,4},{0,2,7},{2,3,1}};
8
5
when using a queue, if (2, 0) is in front of (2, 2) (where (x, y) means the remaining moves y at node 2, then the node 2 where it has 2 moves left wont be visited, since the first (2,0) makes node 2
marked visited. therefore, lost some possible routes through 0-1-2
*/
    
    public int reachableNodes(int[][] edges, int M, int N) {
        HashMap<Integer, HashMap<Integer, Integer>> e = new HashMap<>();
        for (int i = 0; i < N; ++i) e.put(i, new HashMap<>());
        for (int[] v : edges) {
            e.get(v[0]).put(v[1], v[2]);
            e.get(v[1]).put(v[0], v[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[] {M, 0});
        HashMap<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            int moves = pq.peek()[0], i = pq.peek()[1];
            pq.poll();
            if (!seen.containsKey(i)) {
                seen.put(i,moves);
                for (int j : e.get(i).keySet()) {
                    int moves2 = moves - e.get(i).get(j) - 1;
                    if (!seen.containsKey(j) && moves2 >= 0)
                        pq.offer(new int[] { moves2, j});
                }
            }
        }
        int res = seen.size();
        for (int[] v : edges) {
            int a = seen.getOrDefault(v[0],0);
            int b = seen.getOrDefault(v[1],0);
            res += Math.min(a + b, v[2]);
        }
        return res;
    }
