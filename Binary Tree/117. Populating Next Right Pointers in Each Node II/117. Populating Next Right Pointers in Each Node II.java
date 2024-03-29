//Compare to 116. Populating Next Right Pointers in Each Node


//BFS
//O(N)
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

//constant space
//O(1)
//two while loops
public Node connect(Node root) {
        if (root==null) return null;
        Node cur = root;
        while (cur!=null){
            Node itr = cur;
            Node dummy = new Node(0);
            Node prev = dummy;
            while (itr!=null){
                if (itr.left!=null){
                    prev.next = itr.left;
                    prev = prev.next;
                }
                if (itr.right!=null){
                    prev.next = itr.right;
                    prev = prev.next;
                }
                itr = itr.next;
            }
            cur = dummy.next;
            dummy.next = null;
        }
        return root;
    }

//one while loop
public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curP = root;
        TreeLinkNode nextDummyHead = new TreeLinkNode(0);
        TreeLinkNode p = nextDummyHead;
        while (curP != null) {
            if (curP.left != null) {
                p.next = curP.left;
                p = p.next;
            }
            if (curP.right != null) {
                p.next = curP.right;
                p = p.next;
            }
            if (curP.next != null) {
                curP = curP.next;
            }
            else {
                curP = nextDummyHead.next;
                nextDummyHead.next = null;
                p = nextDummyHead;
            }
        }
    }
