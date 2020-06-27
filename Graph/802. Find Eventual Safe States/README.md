Method 1： DFS
when color[i] = 1 means node i is visiting.
when color[i] = 0 means node i is not visited.
when color[i] = 2 means node i has been already visited.
when color[i] = 1 and it is visited again, it is not safe, otherwise it is safe.


Method 2: Topological Sort
Using degree array to record the out-degree, neighbors map to record In-neighbors(for example 0->1, 2->1, map(1) = [0, 2]).
Add the node whose out-degree is 0 into queue and result Set, then process each node in the queue, if the out-degree of one node becomes 0, add it to queue until queue is empty
