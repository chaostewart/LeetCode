class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);   // sort the array first!
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {    // only these numbers could be the 1st elem of a triplets
            if (i > 0 && nums[i] == nums[i - 1])  // skip duplicated 1st ele numbers
                continue;
            int target = 0 - nums[i], lo = i + 1, hi = nums.length - 1;   // lo is the 2nd elem, hi the 3rd elem in a triplets
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {    // found a triplet!
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo + 1] == nums[lo]) lo++;  // skip duplicated 2nd elem
                    while(lo < hi && nums[hi - 1] == nums[hi]) hi--;  // skip duplicated 3rd elem
                    lo++;   // 2nd and 3rd elems moving towards each other
                    hi--;                  
                } else if (nums[lo] + nums[hi] > target) hi--;   // 3rd elem is too large
                else lo++;  // 2nd elem is too small
            }    
        }
        return res;
    }
}
