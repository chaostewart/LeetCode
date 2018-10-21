// this problem is the same as find the number of disconnected continents
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;        // tree of n nodes has n - 1 edges
        int[] roots = new int[n];   
        for (int i = 0; i < n; i++)
            roots[i] = i;
        
        for (int[] e : edges) {
            int set0 = findRoots(roots, e[0]);
            int set1 = findRoots(roots, e[1]);
            if (set0 == set1) return false;             // there's a cycle
            roots[set0] = roots[set1];                  // union two sets
        }
        return true;
    }
    
    private int findRoots(int[] roots, int i) {
        while (roots[i] != i) {
            roots[i] = roots[roots[i]];                 // path compression
            i = roots[i];
        }
        return i;
    }
}
