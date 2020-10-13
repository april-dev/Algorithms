class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List<Integer> res){
        if (root==null) return;
        res.add(root.val);
        for (Node child:root.children) helper(child, res);
        
    }
}

public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root==null) return res;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            for (int i=node.children.size()-1; i>=0; i--){
                stack.add(node.children.get(i));
            }            
        }
        return res;
    }
