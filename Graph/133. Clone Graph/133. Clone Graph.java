//use hashmap to record visited nodes, cannot use hashset because node is pass by reference, so it is stored in set as address
//when helper pass in a visited node from the original graph, although its already in the hashset (created the first time it was encountered), hashset will treat it
//as a different element because their address is different although the node value is the same.
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return helper(node, map);
    }
    public Node helper(Node node, HashMap<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node root = new Node(node.val, new ArrayList<Node>());
        map.put(root.val, root);
        for (Node n: node.neighbors){
            root.neighbors.add(helper(n, map));
        }
        return root;
    }
}

//The above solution does not handle duplicated node values.
//In order to achieve this, use hashmap<Node, Node> where the first Node is the node in the priginal, the second Node is the node in cloned graph
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return helper(node, map);
    }
    public Node helper(Node node, HashMap<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node root = new Node(node.val, new ArrayList<Node>());
        map.put(node, root);
        for (Node n: node.neighbors){
            root.neighbors.add(helper(n, map));
        }
        return root;
    }
}
