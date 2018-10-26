class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            if(nums[left] < nums[right]) 
                return nums[left];
            int mid = (left + right)/2;
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}

// Time: O(logN), Space: O(1)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid + 1] < nums[mid])
                return nums[mid + 1];
            if (mid - 1 >=0 && nums[mid - 1] > nums[mid])
                return nums[mid];
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid - 1;
        }
        return nums[left];
    }
}



