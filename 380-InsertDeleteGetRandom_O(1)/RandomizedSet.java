class RandomizedSet {
    List<Integer> nums;               // declare private variables
    Map<Integer, Integer> map;
    java.util.Random rand;  
    /** Initialize your data structure here. */
    
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();       //  Map<nums.get(i), i>  ===>> <value, index>
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {  
        if (map.containsKey(val)) 
            return false;
        map.put(val, nums.size());      // add to HashMap then ArrayList
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) 
            return false;
        int index = map.get(val);
        if (index != nums.size() - 1) {     // if val to remove is not the last elem, need to do SWAP first
            int lastVal = nums.get(nums.size() - 1);
            map.put(lastVal, index);           
            nums.set(index, lastVal);
        }
        map.remove(val);                // remove the last elem in nums from ArrayList and HashMap
        nums.remove(nums.size() - 1);      // ArrayList is a dynamic structure, size can change
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));      // generate random ints
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
