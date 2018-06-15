/*
The follow-up: allowing duplicates in the array.
For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().

The idea is to add a set to the hashMap to remember all the locations of a duplicated number.
*/
class RandomizedSet {
    List<Integer> nums;               // declare private variables
    Map<Integer, Set<Integer>> map;
    java.util.Random rand = new Random();    /// but rand needs to be initialized here
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();       // map<nums.get(i), i>   -> <value, index>
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);   
        if (!contain) {
            map.put(val, new HashSet<Integer>()); // create a HashSet for this val in map first
        }
        map.get(val).add(nums.size());      // add to ArrayList and HashMap's HashSet
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) return false;
        int index = map.get(val).iterator().next();  // to get elem from a set, need iterator().next()
        map.get(val).remove(index);
        if (index != nums.size() - 1) {     // if val to remove is not the last elem, need to do SWAP first
            int lastVal = nums.get(nums.size() - 1);
            map.get(lastVal).remove(nums.size() - 1);
            map.get(lastVal).add(index);    
            nums.set(index, lastVal);
        }
        if (map.get(val).isEmpty())    // because we delete from a set, need to check if it's empty
            map.remove(val);   
        nums.remove(nums.size() - 1);  // remove the last elem in nums from ArrayList and HashMap
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