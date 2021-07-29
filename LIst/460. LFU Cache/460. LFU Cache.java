class LFUCache {
    int capacity, size, minFreq;
    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DLinkedList> freqMap;
  
    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(0,new DLinkedList(0));
    }
  
    public int update(Node node){
        int freq = node.freq;
        freqMap.get(freq).delete(node);
        node.freq++;
        freqMap.putIfAbsent(node.freq, new DLinkedList(node.freq));
        freqMap.get(node.freq).add(node);
        if (freqMap.get(minFreq).isEmpty()) minFreq++;
        return node.value;
    }
    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        return update(node);
    }
    public void put(int key, int value) {
        if (capacity==0) return;
        if (keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }
        if (size>=capacity){
            Node old = freqMap.get(minFreq).pop();
            keyMap.remove(old.key);
            size--;
        }
        Node node = new Node(key, value);
        freqMap.get(0).add(node);
        keyMap.put(key, node);
        minFreq = 0;
        size++;
    }
  
    class Node{
        int freq, key, value;
        Node prev, next;
        Node (int key, int value){
            this.key = key;
            this.value = value;
            freq = 0;
        }
    }
  
    class DLinkedList{
        int freq;
        Node head, tail;
        DLinkedList(int freq){
            this.freq = freq;
            head = new Node(0,0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        void add(Node node){
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;
        }
        void delete(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        boolean isEmpty(){
            return head.next==tail;
        }
        Node pop(){
            if (isEmpty()) return null;
            Node node = tail.prev;
            delete(node);
            return node;
        }
    }
}
