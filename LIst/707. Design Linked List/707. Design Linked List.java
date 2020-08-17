class MyLinkedList {
    class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    Node head;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index>=size || head==null) return -1;
        Node cur = head;
        while (index>0){
            cur = cur.next;
            index -= 1;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node temp = head;
        head = new Node(val);
        head.next = temp;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head==null) {
            head = new Node(val);
        }else{
            Node cur = head;
            while (cur.next!=null){
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index>size) return;
        if (index==0) addAtHead(val);
        Node cur = head;
        Node prev = cur;
        for (int i=0; i<index; i++){
            prev = cur;
            cur= cur.next;
        }
        Node insert = new Node(val);
        prev.next = insert;
        insert.next = cur;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index>=size) return;
        Node cur = head;
        if (index==0) {
            head = head.next;
        }else{
            Node prev = cur;
            for (int i=0; i<index-1; i++){
                prev = cur;
                cur= cur.next;            
            }
            cur.next = cur.next.next;
        }
        size--;
    }
}
