// similiar to 136. Single Number problem
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        return ans^n;
    }
}
/*
since the n numbers are from [0, n], we can just add all the (n+1) numbers from [0, n] together 
and minus the sum of the n numbers in array.
*/
class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }
}
