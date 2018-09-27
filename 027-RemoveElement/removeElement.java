class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        // always do something if current value is the unwanted value
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) 
                nums[start] = nums[end--];
            else
                start++;
        }
        return start;
        */
        // ignore unwanted values, only overwrite some of them if there's any wanted values available
        int slow = -1, fast = 0;
        while (fast < nums.length) {
            // if curr is not the value to remove, copy it to slow 
        	if (nums[fast] != val)
        		nums[++slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }
}