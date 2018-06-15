class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        backtrack(res, new ArrayList<>(), nums, 0);   // first subset is []
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> sublist, int[] nums, int start) {
        res.add(new ArrayList(sublist));     // why pass sublit inside a new ArrayList?!  
        for (int i = start; i < nums.length; i++) {
            sublist.add(nums[i]);
            backtrack(res, sublist, nums, i + 1);
            sublist.remove(sublist.size() - 1);
        }
    }
}