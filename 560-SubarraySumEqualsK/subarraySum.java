// Time complexity O(n), Space complexity O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        // Map <the sum of subarray ending at i, frequency of this sum value>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // add 1 to result when sum equals k
        
        for (int i : nums) {
            sum += i;
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }   
        return result; 
    }
}