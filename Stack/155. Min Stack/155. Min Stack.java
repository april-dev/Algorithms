class MinStack {
    Node head ;
    
    /** initialize your data structure here. */
    public MinStack() {
       
    }
    
    public void push(int val) {
         if (head==null) head = new Node(val, val);
        else {
            Node node = new Node(val, Math.min(head.min, val));
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
}
