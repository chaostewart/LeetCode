class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int[] candidates, int start, int target, List<List<Integer>> ans, List<Integer> sublist) {
        if (target == 0) {
            ans.add(new ArrayList(sublist));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            /*
            start from i=start, now it is i > start, which means we've tried the nubmers between start to i-1.
            Now we are at candidate[i] and candidate[i] == candidate[i-1]. Now need to try it another time.
            */
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] <= target) {
                sublist.add(candidates[i]);
                backtrack(candidates, i+1, target - candidates[i], ans, sublist);
                sublist.remove(sublist.size() - 1);
            }
        }
    }
}