 class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);     // reverse the whole array
        reverse(nums, 0, k - 1);               // reverse the frist k elements
        reverse(nums, k, nums.length - 1);     // reverse the rest of the elements
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];   // O(1) space, O(n) run time
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}