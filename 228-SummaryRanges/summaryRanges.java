class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while(i + 1 < nums.length && (nums[i+1] - nums[i]) == 1)
                i++;      
            if (curr != nums[i]) 
                res.add(curr + "->" + nums[i]);
            else
                res.add(curr + "");
        }
        return res;
    }
}