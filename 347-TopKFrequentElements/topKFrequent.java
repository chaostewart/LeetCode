class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {      
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int num: map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null)    // no number has been added to this freq bucket
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && k > 0; --i) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }    
        return res;
        
        /* // min heap gives a very slow solution
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>(map.size(), (a, b) -> (map.get(a)).compareTo(map.get(b)));
        for (int i : map.keySet()) {
            heap.add(i);
            if (heap.size() > k)
                heap.poll();
        }
        List<Integer> res = new ArrayList<>();
        for (int j : heap) 
            res.add(0, j);
        return res;
        */
    }
}
