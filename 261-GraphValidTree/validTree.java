class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;  // tree of n nodes has n - 1 edges
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for (int i = 0; i < edges.length; i++) {
            int setA = find(nums, edges[i][0]);   
            int setB = find(nums, edges[i][1]);
            if (setA == setB) return false;   // there's a cycle
            nums[setA] = setB;  // union two sets
        }
        return true;
    }
    
    private int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}