class Solution {
    private int[] original;
    private Random random;
    
    public Solution(int[] nums) {
        this.original = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] nums = new int[original.length];
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            nums[i] = nums[j];
            nums[j] = original[i];
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */