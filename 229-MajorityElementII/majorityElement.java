class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, k = 3;  //in this question, k=3 specifically
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        // there will be at most k-1 candidates who have counts more than n/k
        int[] candidates = new int[k - 1];
        int[] counts = new int[k - 1];
        
        // first pass: find top k-1 candicates with most votes
        for (int candi: nums) {
            boolean settled = false;
            // if current candidate is on the top list, add one more vote. This round is settled.
            for (int i = 0; i < k - 1; i++) 
                if (candidates[i] == candi) {
                    counts[i]++;
                    settled = true;
                    break;      // break from inner loop
                } 
            if (settled) continue;

            // else if a candidate on the top list has zero votes for now
            // replace it with current candidate. This round is settled.
            for (int i = 0; i < k - 1; i++)
                if (counts[i] == 0) {       
                    candidates[i] = candi;
                    counts[i]++;
                    settled = true;
                    break;      // break from inner loop
                } 
            if (settled) continue;
            
            // else: the current candidate is not eligible for being on the top list for now
            // but it will negate all top candiates' votes
            for (int i = 0; i < k - 1; i++) 
                counts[i] = counts[i] > 0 ? counts[i] - 1 : 0;
        }
        
        // second pass: count top candidates total votes
        Arrays.fill(counts, 0);
        for (int candi: nums) 
            for (int i = 0;i < k - 1; i++)
                if (candidates[i] == candi) {
                    counts[i]++;
                    break;
                }
        // add to resuilt if a candidate's total votes are more than n/k
        for (int i = 0; i < k - 1; i++) 
            if (counts[i] > n/k) 
                res.add(candidates[i]);
        
        return res;
    }
}