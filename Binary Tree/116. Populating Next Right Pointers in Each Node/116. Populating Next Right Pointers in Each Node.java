//level order traversal
public Node connect(Node root) {
                if(root==null)return null;
                if(root.left==null && root.right==null)return root;
                Queue<Node> q=new LinkedList<>();
                q.add(root);
                q.add(null);
        
                while(!q.isEmpty()){
                    Node temp=q.poll();
                    if(temp==null){
                        if(q.isEmpty())break;
                        q.add(null);
                    }else{
                        temp.next=q.peek();
                        if(temp.left!=null)
                            q.add(temp.left);
                        if(temp.right!=null)
                            q.add(temp.right);
                    }
                }
                
                return root;
    }



//the code below only works for perfect binary tree, it will not work for case [1,2,3,4,5,null,7], but the code above works for all cases (Q117).
public Node connect(Node root) {
        if (root==null) return root;
        Node pre = root;
        Node cur = null;
        while(pre.left!=null){
            cur = pre;
            while (cur!=null){
                cur.left.next = cur.right;
                if (cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
    
    
//recursive 
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        connectNodes(root.left, root.right);
    }
    
    public void connectNodes(TreeLinkNode node1, TreeLinkNode node2) {
        node1.next = node2;
        if(node1.left != null) {
            connectNodes(node1.right, node2.left);
            connectNodes(node1.left, node1.right);
            connectNodes(node2.left, node2.right);
        }
    } 
}
