class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // two pointers
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) return res;
        int left = 0, right = numbers.length - 1;
        while (left < right) {   // keep moving two pointers towards each other, may not use the same element twice
            if (numbers[left] + numbers[right] == target) {
                res[0] = ++left; res[1] = ++right;   // answers are not zero-based
                return res;
            }
            else if (numbers[left] + numbers[right] > target)
                right--;
            else 
                left++;
        }
        return res;
    }
}
