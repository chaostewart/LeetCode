// just a newer version
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> sublist, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(sublist));
            return;
        }
        for (int i = start; i < candidates.length; i++)
            if (candidates[i] <= target) {
                sublist.add(candidates[i]);
                backtrack(res, sublist, candidates, i, target - candidates[i]);
                sublist.remove(sublist.size() - 1);
            }               
    }
}



class Solution {
    public List<List<Integer>> (int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // note: sorting the input array would slow it down
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> sublist, int [] candidates, int remain, int start){
        if (remain < 0) return;  // if remaining target < 0, this sublist is not a solution
        else if (remain == 0) res.add(new ArrayList<>(sublist));
        else {   // if remaining target > 0, keep trying
            for(int i = start; i < candidates.length; i++) {
                sublist.add(candidates[i]);   // try the start entry (again), 
                backtrack(res, sublist, candidates, remain - candidates[i], i); // not i + 1 because we can reuse same elements
                sublist.remove(sublist.size() - 1);   // used up the ith entry, remove it, move on to the (i+1)th entry
            }
        }
    }

}
