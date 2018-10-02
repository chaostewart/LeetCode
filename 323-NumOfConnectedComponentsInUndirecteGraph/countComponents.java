class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++)
            roots[i] = i;
        for (int[] e : edges) {
            int root1 = findRoot(roots, e[0]);
            int root2 = findRoot(roots, e[1]);
            if (root1 != root2) {
                roots[root1] = root2;   // union
                n--;
            }
        }
        return n;
    }
    
    private int findRoot(int[] roots, int v) {
        while(roots[v] != v) {
            roots[v] = roots[roots[v]];   // path compression
            v = roots[v];
        }
        return v;
    }
}