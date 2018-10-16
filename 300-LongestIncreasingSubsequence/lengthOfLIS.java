public class Solution {
    public int lengthOfLIS(int[] nums) {
        /* sol 1: slightly slower, easy to understand this dp
        //Time complexity: O(n^2). Two loops of n are there.
        //Space complexity : O(n). dp array of size n is used.
        
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int prevMax = 0;
            for (int j = 0; j < i; j++) 
                if (nums[i] > nums[j]) 
                    prevMax = Math.max(prevMax, dp[j]);

            dp[i] = prevMax + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        */

        // sol 2: faster dp --- brilliant
        // Time: O(nlogn), space: O(n)
        // dp[i] stores smallest value of the the last elem among all LIS of length i+1
        // dp is an increasing array
        int[] dp = new int[nums.length];  
        int len = 0;
        for (int num : nums) {
            // Each time we only do one of the two:
            // - if num is larger than all dp[i], append it, increase the len by 1
            // - if dp[i-1] < num <= dp[i], update dp[i]
            int start = 0, end = len;
            while (start < end) {
                int mid = start + (end - start)/2;
                if (dp[mid] < num)
                    start = mid + 1;
                else
                    end = mid;
            }
            dp[start] = num;
            if (start == len) 
                ++len;
        }
        return len;
    }
}
