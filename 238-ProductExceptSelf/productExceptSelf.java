class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];   
        output[0] = 1;   // initilize 1st output elem to be 1
        // the following loop calculates the product of all elems on the left side of each elem i
        for (int i = 1; i < len; i++) 
            output[i] = output[i-1] * nums[i-1];
        
        // the following loop then multiplies the product of all elems on the right side of each elem i
        int right = 1;
        for (int j = len - 1; j >= 0; j--) {
            output[j] *= right;
            right *= nums[j];
        }
        
        return output;
    }
}
