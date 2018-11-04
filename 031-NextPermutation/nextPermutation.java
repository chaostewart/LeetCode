
/*
1. Reverse find first number which breaks descending order.
2. Exchange this number with the least number that's greater than this number.
3. Reverse sort the numbers after the exchanged number.
*/
// e.g. 2, 3, 6, 5, 4, 1
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) 
            if (nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        for (int i = nums.length - 1; i > pivot; i--) 
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                reverse(nums, pivot + 1, nums.length - 1);
                return;
            } 
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) 
            swap(nums, lo++, hi--);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
