class LRUCache {
    // Node of a double-linked list
    private class Node {
        int key, value;
        Node prev, next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
        Node() {
            this(0, 0);
        }
    }
    
    private int capacity, count;
    private Node head, tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        count = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        update(n);     // key exists, move this node to the front of the list
        return n.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;   // key exists, update its value
            update(n);    // move this node to the front of the list   
        }
        else {
            Node n = new Node(key, value);   // key doesn't exist, create a new node
            map.put(key, n);
            add(n);   // add new node to the front of the list
            ++count;   // increase the length of the list   
            if (count > capacity) {     // if exceeding capacity, remove the node at the end
                Node toDel = tail.prev;
                map.remove(toDel.key);
                remove(toDel);
                --count;
            } 
         } 
    }
    
    private void update(Node node) {
        remove(node);
        add(node);
    }
    
    private void remove(Node node) {
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
    
    private void add(Node node) {
        Node oldFirst = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldFirst;
        oldFirst.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */