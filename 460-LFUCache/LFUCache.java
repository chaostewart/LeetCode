class LFUCache {
    private int min;
    private int capacity;
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToLFUKeys;
    /*
    LinkedHashSet: Hash table and linked list implementation of the Set interface, with predictable iteration order. This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order). Note that insertion order is not affected if an element is re-inserted into the set. 
    */
    public LFUCache(int capacity) {
        min = -1;
        this.capacity = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToLFUKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        int freq = keyToFreq.get(key);
        freqToLFUKeys.get(freq).remove(key);   // remove key from current frequency (since we will increase freq)
        if (freq == min && freqToLFUKeys.get(freq).size() == 0)   // nothing in the current min bucket
            min++;
        updateFreq(key, freq + 1);
        return keyToVal.get(key);
    }
    

    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);       // update key's value
            get(key);                       // update key's freq
            return;
        }
        
        if (keyToVal.size() == capacity) 
            evict(freqToLFUKeys.get(min).iterator().next());        // evict LRU from this min freq bucket
        
        keyToVal.put(key, value);           // adding new key and value
        min = 1;
        updateFreq(key, 1);                 // adding new key and freq
    }
    
    private void updateFreq(int key, int freq) {
        keyToFreq.put(key, freq);
        if (!freqToLFUKeys.containsKey(freq))
            freqToLFUKeys.put(freq, new LinkedHashSet<Integer>());
        freqToLFUKeys.get(freq).add(key);
    }
    
    
    private void evict(int key) {
        keyToVal.remove(key);
        keyToFreq.remove(key);
        freqToLFUKeys.get(min).remove(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */