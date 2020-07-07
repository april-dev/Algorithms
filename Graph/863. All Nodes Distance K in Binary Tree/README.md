As we know, if the distance from a node to target node is k, the distance from its child to the target node is k + 1 unless the child node is closer to the target node which means the target node is in it's subtree.

To avoid this situation, we need to travel the tree first to find the path from root to target, to:

store the value of distance in hashamp from the all nodes in that path to target
Then we can easily use dfs to travel the whole tree. Every time when we meet a treenode which has already stored in map, use the stored value in hashmap instead of the value from its parent node
