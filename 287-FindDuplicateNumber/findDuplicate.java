class Solution {
    public int findDuplicate(int[] nums) {

    /*  // space: O(n)
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return i;
            else 
                set.add(i);
        }
        return -1;
    */
        // Time: O(n), Space: O(1)
        // Find the intersection point of the two runners.
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            //System.out.println(slow + "," + fast);
        } while (slow != fast) ;

        // Find the "entrance" to the cycle.
        fast = 0; 
        do {
            slow = nums[slow];
            fast = nums[fast];
            //System.out.println(slow + "," + fast);
        } while (slow != fast) ;   
        
        return slow;
    }
}
