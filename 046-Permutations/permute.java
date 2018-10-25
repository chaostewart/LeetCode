// slightly more efficient version, remove a number from nums if it's been added to a sublist
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Store numbers in a list
        List<Integer> numlist = new ArrayList(nums.length);
        for (int i : nums)
            numlist.add(i);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), numlist);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> sublist, List<Integer> numlist) {
        // number list is empty <==> sublist has all numbers in it
        if (numlist.isEmpty())
            res.add(new ArrayList(sublist));
        else
            for (int i = 0; i < numlist.size(); i++) {
                Integer tmp = numlist.get(i);    // Change var type from Integer to int will slow it down...why?
                sublist.add(tmp);
                numlist.remove(i);
                backtrack(res, sublist, numlist);
                sublist.remove(sublist.size() - 1);
                numlist.add(i, tmp);
            }
    }  
    
}


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
            // However, this for loop always starts from 0 for each recursive call
            // seems inefficient to check if a number has been added previously
            for (int i = 0; i < nums.length; i++) {
                if (sublist.contains(nums[i]))
                    continue;
                sublist.add(nums[i]);
                backtrack(res, sublist, nums);
                sublist.remove(sublist.size() - 1);
            }
    }
    
}
