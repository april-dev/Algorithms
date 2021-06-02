public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> q = new LinkedList<>();
        Node dummy = root;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            while (size>0){
                Node cur = q.poll();
                size--;
             if (cur.left!=null) q.add(cur.left);
                if (cur.right!=null) q.add(cur.right);
                if (size==0) break;
                cur.next = q.peek();
            }            
        }
        return dummy;
    }
