class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<intValue, intIndex>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // check if the current number's complement is already in the map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);  // if not, map the current number and its index
        }
        //return new int[2];  // requires a return statement
        throw new IllegalArgumentException("No solution");
    }
}
