// this one-pass algorithm is bounded by O(2n),
// meaning that at most each element will be seen and operated twice (in the case of all 0s)
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int redPtr = 0, bluePtr = nums.length - 1, i = 0;
        while (i <= bluePtr) {
            if (nums[i] == 2) {
                swap(nums, i, bluePtr);
                bluePtr--;
            }
            else if (nums[i] == 0) {
                swap(nums, redPtr, i);
                redPtr++;
                i++;
            }
            else
                i++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}