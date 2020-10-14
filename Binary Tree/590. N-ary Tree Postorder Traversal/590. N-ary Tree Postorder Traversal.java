class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List<Integer> res){
        if (root==null) return;
        for (Node child:root.children) helper(child, res);
        res.add(root.val);
    }
}

public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root==null) return res;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            res.addFirst(cur.val);
            for (Node child:cur.children) stack.add(child);
        }
        
        return res;
    }
