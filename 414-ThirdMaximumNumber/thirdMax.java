class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;   // Integer is non primitive but an object class
        for (Integer n: nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;      // duplicates? skip
            if (max1 == null || n > max1) {   // first assignment of max1 or find largest int so far
                max3 = max2;         // shifting down
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {    // first assignment of max2 or find new val for max2
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;   // note: nums.length >= 3 wouldn't always work e.g. when nums == null
    }
}