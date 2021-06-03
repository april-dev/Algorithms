//My solution based on 117. Populating Next Right Pointers in Each Node II
public Node connect(Node root) {
         Node dummy = new Node(0);
        Node prev = dummy;
        Node cur = root;
        if (root==null) return null;
        while (cur.left!=null){
           
            prev.next = cur.left;
            prev= prev.next;
            prev.next = cur.right;
            prev= prev.next;
            if (cur.next!=null) cur = cur.next;
            else{
                cur = dummy.next;
                dummy.next = null;
                prev = dummy;
            }
        }
        return root;
    }



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
