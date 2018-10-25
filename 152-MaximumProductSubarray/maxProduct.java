// Time: O(n), space: O(1)
class Solution {
    public int maxProduct(int[] nums) {
        // ans stores the max we have found so far
        int ans = nums[0];
        // prevMax/prevMin stores the max/min product of subarray that ends with the current number nums[i]
        int prevMax = ans, prevMin = ans;
        for (int i = 1; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger, so we swap them
            if (nums[i] < 0) {
                int tmp = prevMax;
                prevMax = prevMin;
                prevMin = tmp;
            }
            // update max/min for the current number nums[i]
            prevMax = Math.max(nums[i], nums[i] * prevMax);
            prevMin = Math.min(nums[i], nums[i] * prevMin);
            
            // the newly computed max value is a candidate for final result
            ans = Math.max(ans, prevMax);
        }
        return ans;
    }
}