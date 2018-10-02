class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // <number, frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i : nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
    
        for(int j : nums2)
            if(map.containsKey(j) && map.get(j) > 0) {
                res.add(j);
                map.put(j, map.get(j) - 1);
            }
    
       int[] ans = new int[res.size()];
       for(int k = 0; k < res.size(); k++)
           ans[k] = res.get(k);

       return ans;
    }
}

/*
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

- If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array nums2 that fit into the memory, 
and record the intersections.

- If both nums1 and nums2 are so huge that neither fit into the memory, sort them using external sort, 
read (let's say) 2G of each into memory and then using the 2 pointer technique, then read 2G more from the array that has been exhausted. 
Repeat this until no more data to read from disk.
*/