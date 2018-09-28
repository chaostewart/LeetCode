class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[] {-1, -1};
        if (nums.length == 0) return res;
        // Search for the left bound
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) 
                i = mid + 1;
            else 
                j = mid;
        }
        if (nums[i] != target) 
            return res;
        else 
            res[0] = i;

        // Search for the right bound
        j = nums.length - 1; 
        while (i < j) {
            int mid = i + (j + 1 - i) / 2;  // make mid biased to the right
            if (nums[mid] > target) 
                j = mid - 1;  
            else 
                i = mid;    
        }
        res[1] = j;
        return res;
    }
}