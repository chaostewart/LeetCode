class Solution {
    public List<String> topKFrequent(String[] words, int k) { 
        Map<String, Integer> map = new HashMap<>();
        for (String s: words)
            map.put(s, map.getOrDefault(s, 0) + 1);   // map counts the freq of each word
       
        /*
        // sol 1: time complexity = O(nlogn) where n is the size of words, space = o(n)
        List<String> res = new ArrayList<>(map.keySet());
        // Comparator: if we want ascending order in freq, map.get(w1) - map.get(w2); descending, w2 - w1
        Collections.sort(res, (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return res.subList(0, k);
        */
        
        // sol 2: use a heap of size k，  time complexity = O(nlogk)     
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) :
                                                        map.get(w1) - map.get(w2));  // Note: comparator is reversed!
        
        for (String s: map.keySet()) {  // iterate through keys but not words again.
            heap.add(s);                // offer() == add() which is equivalent to push()
            if (heap.size() > k)
                heap.poll();            // poll() is equivalent to pop()
        }
        
        List<String> res = new ArrayList<>();
        while(!heap.isEmpty())      
            res.add(0, heap.poll())    // adding each word to the front of the list is faster than reversing the list later
        /*
            res.add(heap.poll());  
        Collections.reverse(res);      // The head of queue is the least element w.r.t. the specified ordering.
        */
        return res;
   
    }
}
