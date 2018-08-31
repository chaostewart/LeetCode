
/*
1. Reverse find first number which breaks descending order.
2. Exchange this number with the least number that's greater than this number.
3. Reverse sort the numbers after the exchanged number.
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) 
            i--;
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) 
                j--;    
            swap(nums, i, j);
        }
        // else (i == -1), no next permutation is possible
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