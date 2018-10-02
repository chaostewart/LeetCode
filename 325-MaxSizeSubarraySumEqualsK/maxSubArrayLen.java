class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, ans = 0;
        // <sum of all elements from index 0 to i, index i>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) 
                ans = i + 1;
            else if (map.containsKey(sum - k)) 
                ans = Math.max(ans, i - map.get(sum - k));
            if (!map.containsKey(sum)) 
                map.put(sum, i);
        }
        return ans;
    }
}