class LRUCache {
    // Node of a double-linked list can remove itself without other reference
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
    
    private int capacity, size;
    private Node head, tail;          //create a pseudo head and tail to mark the boundary
    private Map<Integer, Node> map;  // Time: O(1)
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))  
            return -1;
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
            ++size;   // increase the length of the list   
            if (size > capacity) {     // if exceeding capacity, remove the node at the end
                Node toDel = tail.prev;
                map.remove(toDel.key);
                remove(toDel);
                --size;
            } 
         } 
    }
    
    private void update(Node n) {
        remove(n);
        add(n);
    }
    
    private void remove(Node n) {
        Node before = n.prev, after = n.next;
        before.next = after;
        after.prev = before;
    }
    
    private void add(Node n) {
        Node oldFront = head.next;
        head.next = n;
        n.prev = head;
        n.next = oldFront;
        oldFront.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
