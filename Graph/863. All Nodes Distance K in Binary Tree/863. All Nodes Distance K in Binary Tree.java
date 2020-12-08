 //Soliution 1: BFS + HashMap
// use hashmap to store parent child relationship, turn a binary tree to a graph
class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        graph(root, null);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            if (K==0){
                for (int i=0; i<size; i++) res.add(queue.poll().val);
                return res;
            }
            while (size-->0){
                TreeNode cur = queue.poll();
                for (TreeNode neighbor: map.get(cur)){
                    if (visited.contains(neighbor)) continue;
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            K--;
        }
        return res;
    }
    public void graph(TreeNode root, TreeNode parent){
        if (root==null) return;
        if (!map.containsKey(root)){
            map.put(root, new ArrayList<>());
            if (parent!=null) {
                map.get(root).add(parent);
                map.get(parent).add(root);
            }
            graph(root.left, root);
            graph(root.right, root);
        }
    }
}


//BFS + clone graph
//similar approach as solution 1, except that the binary tree is converted to a graph by adding a parent feature.
class Solution {
    private GNode targetGNode;
    
    private class GNode {
        TreeNode node;
        GNode parent, left, right;
        GNode (TreeNode node) {
            this.node = node;
        }
    }           
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer> ();
        if (root == null || K < 0) return res;
        cloneGraph(root, null, target);
        if (targetGNode == null) return res;
        Set<GNode> visited = new HashSet<GNode>();
        Queue<GNode> q = new LinkedList<GNode>();
        q.add(targetGNode);
        visited.add(targetGNode);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size ; i++) res.add(q.poll().node.val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                GNode gNode = q.poll();
                if (gNode.left != null && !visited.contains(gNode.left)) { visited.add(gNode.left); q.add(gNode.left); }
                if (gNode.right != null && !visited.contains(gNode.right)) { visited.add(gNode.right); q.add(gNode.right); }
                if (gNode.parent != null && !visited.contains(gNode.parent)) { visited.add(gNode.parent); q.add(gNode.parent); }
            }
            K--;
        }
        return res;
    }
    
    private GNode cloneGraph(TreeNode node, GNode parent, TreeNode target) {
        if (node == null) return null;
        GNode gNode = new GNode(node);
        if (node == target) targetGNode = gNode;
        gNode.parent = parent;
        gNode.left = cloneGraph(node.left, gNode, target);
        gNode.right = cloneGraph(node.right, gNode, target);
        return gNode;
    }
}



//Solution 3: DFS + hashmap
Map<TreeNode, Integer> map = new HashMap<>();
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }
    
    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
		int right = find(root.right, target);
		if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    
    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }
    
    
//Solution 4: DFS without using hashmap: same idea, combine two recursive function
public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        if (K == 0) {
            res.add(target.val);
        } else {
            dfs(res, root, target.val, K ,0);
        }
        return res;
    }
    
    private int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {
        if (node == null) return 0;
        
        if (depth == K) {
            res.add(node.val);
            return 0;
        }
        
        int left, right;
        if (node.val == target || depth > 0) {
            left = dfs(res, node.left, target, K, depth + 1);
            right = dfs(res, node.right, target, K, depth + 1);
        } else {
            left = dfs(res, node.left, target, K, depth);
            right = dfs(res, node.right, target, K, depth);
        }
        
        if (node.val == target) return 1;
        
        if (left == K || right == K) {
            res.add(node.val);
            return 0;
        }
        
        if (left > 0) {
            dfs(res, node.right, target, K, left + 1);
            return left + 1;
        }
        
        if (right > 0) {
            dfs(res, node.left, target, K, right + 1);
            return right + 1;
        }
        
        return 0;
    }
    
