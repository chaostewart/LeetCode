// https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i = 2; i <= n; ++i) {
            System.out.println("============================================");
            System.out.println("i = " + i + ":");
            for(int j = 1; j <= i; ++j) {
                System.out.println("j = " + j + ":");
                G[i] += G[j-1] * G[i-j];
                System.out.println("G[j-1] * G[i-j] = G[" + (j-1) + "] * G[" + (i-j) +"] = " +  G[j-1] + " * " +  G[i-j] + " = "+ G[j-1] * G[i-j]);
                System.out.println("G[i] = G[" + i +"] = " + G[i]);
            }
        }
        
        return G[n];
    }
}