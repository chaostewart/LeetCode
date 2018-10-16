
/*
1. Reverse find first number which breaks descending order.
2. Exchange this number with the least number that's greater than this number.
3. Reverse sort the numbers after the exchanged number.
*/
// e.g. 2, 3, 6, 5, 4, 1
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) 
            i--;
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) 
                j--;  
            // i points to 3, j points to 4 --> 2, 4, 6, 5, 3, 1
            swap(nums, i, j);
        }
        // else (i == -1), no next permutation is possible
        // --> 2, 4, 1, 3, 5, 6
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
