/*
Tree properties:
(1) A tree is an undirected graph in which any two vertices are
connected by exactly one path.

(2) Any connected graph who has n nodes with n-1 edges is a tree.

(3) The degree of a vertex of a graph is the number of
edges incident to the vertex.

(4) A leaf is a vertex of degree 1. An internal vertex is a vertex of
degree at least 2.

(5) A path graph is a tree with two or more vertices that is not
branched at all.

(6) A tree is called a rooted tree if one vertex has been designated
the root.

(7) The height of a rooted tree is the number of edges on the longest
downward path between root and a leaf.

/*
keep deleting leaves layer-by-layer, until reach the root.
first find all the leaves, then remove them. After removing, some nodes will become new leaves. So we can continue remove them. 
Eventually, there is only 1 or 2 nodes left. If there is only one node left, it is the root. If there are 2 nodes, either of them could be a possible root.
*/

/*
More precisely, if the number of nodes is V, and the number of edges is E. The space complexity is O(V+2E), for storing the whole tree. 
The time complexity is O(E), because we gradually remove all the neighboring information. For a tree, if V=n, then E=n-1. 
Thus both time complexity and space complexity become O(n).
*/

public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer> leafs = new ArrayList<>();
        if (n == 1) {
            leafs.add(0);
            return leafs;
        }
        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i=0; i<n; i++) neighbors.add(new HashSet<>());
        for (int[] edge:edges){
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        for (int i=0; i<n; i++){
            if (neighbors.get(i).size() == 1) leafs.add(i);
        }
        while (n > 2){
            n -= leafs.size();
            List<Integer> newLeafs = new ArrayList<>();
            for (int leaf:leafs){
                int j = neighbors.get(leaf).iterator().next();
                neighbors.get(j).remove(leaf);
                if (neighbors.get(j).size() == 1) newLeafs.add(j);
            }
            leafs = newLeafs;
        }
        return leafs;
    }



//Solution 2: Longest Path
/*
It is easy to see that the root of an MHT has to be the middle point (or two middle points) of the longest path of the tree.
Though multiple longest paths can appear in an unrooted tree, they must share the same middle point(s).

Computing the longest path of a unrooted tree can be done, in O(n) time, by tree dp, or simply 2 tree traversals (dfs or bfs).
The following is some thought of the latter.

Randomly select a node x as the root, do a dfs/bfs to find the node y that has the longest distance from x.
Then y must be one of the endpoints on some longest path.
Let y the new root, and do another dfs/bfs. Find the node z that has the longest distance from y.

Now, the path from y to z is the longest one, and thus its middle point(s) is the answer.
*/
public class _310 {
    int n;
    List<Integer>[] e;

    private void bfs(int start, int[] dist, int[] pre) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;
        visited[start] = true;
        pre[start] = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : e[u])
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                    pre[v] = u;
                }
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) return new ArrayList<>();
        this.n = n;
        e = new List[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            e[u].add(v);
            e[v].add(u);
        }

        int[] d1 = new int[n];
        int[] d2 = new int[n];
        int[] pre = new int[n];
        bfs(0, d1, pre);
        int u = 0;
        for (int i = 0; i < n; i++)
            if (d1[i] > d1[u]) u = i;

        bfs(u, d2, pre);
        int v = 0;
        for (int i = 0; i < n; i++)
            if (d2[i] > d2[v]) v = i;

        List<Integer> list = new ArrayList<>();
        while (v != -1) {
            list.add(v);
            v = pre[v];
        }

        if (list.size() % 2 == 1) return Arrays.asList(list.get(list.size() / 2));
        else return Arrays.asList(list.get(list.size() / 2 - 1), list.get(list.size() / 2));
    }
}
