class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else 
                hi = mid;
            }
        int offset = hi;    // hi points to the real start
        lo = 0; hi = n - 1;
        // The usual binary search and accounting for rotation.
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realmid = (mid + offset) % n;
            if (nums[realmid] == target)
                return realmid;
            if (nums[realmid] < target)
                lo = mid + 1;
            else 
                hi = mid - 1;
        }
        return -1;
    }
}