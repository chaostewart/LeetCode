// Time: O(logN), Space: O(1)
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no rotation.
        if (nums[right] > nums[0]) 
            return nums[0];   

        // Binary search way
        while (left <= right) {
          // Find the mid element
            int mid = left + (right - left) / 2;

          // if the mid element is greater than its next element then mid+1 element is the smallest
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];  

          // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

          // ans is in the right half
            if (nums[mid] > nums[0])
                left = mid + 1;
            else
            // ans is in the left half
                right = mid - 1;    
        }
        return -1;
    }
}