class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> sublist, int[] nums) {
        if (sublist.size() == nums.length)
            res.add(new ArrayList(sublist));
        else
            for (int i = 0; i < nums.length; i++) {
                if (sublist.contains(nums[i]))
                    continue;
                sublist.add(nums[i]);
                backtrack(res, sublist, nums);
                sublist.remove(sublist.size() - 1);
            }
    }
    
}