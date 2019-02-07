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

// Binary search. Time: O(nlogn). right pointer is initialized as n instead of n-1
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) 
                right = mid;
            else left = mid+1;
        }
        return left;
    }
}
