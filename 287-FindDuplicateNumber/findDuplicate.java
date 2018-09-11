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
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}