/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(DFS(root.left, 1, root.val), DFS(root.right, 1, root.val));
    }
    
    private int DFS(TreeNode node, int count, int parentVal) {
        if (node == null) return count;
        count = (node.val - parentVal == 1) ? count + 1 : 1;
        int left = DFS(node.left, count, node.val);
        int right = DFS(node.right, count, node.val);
        return Math.max(count, Math.max(left, right));
    }
}

