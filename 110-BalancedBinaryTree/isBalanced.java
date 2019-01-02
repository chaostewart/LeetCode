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
    public boolean isBalanced(TreeNode root) {
        int[] res = new int[1];
        getDepth(root, res);
        return res[0] <= 1;
    }
    
    private int getDepth(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = getDepth(root.left, res);
        int right = getDepth(root.right, res);
        res[0] = Math.max(res[0], Math.abs(left - right));
        return 1 + Math.max(left, right);
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int heightL = getHeight(root.left);
        int heightR = getHeight(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(heightL - heightR) <= 1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
