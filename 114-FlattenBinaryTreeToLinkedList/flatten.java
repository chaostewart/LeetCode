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
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    // 'reversed' preorder traversal
    private TreeNode flatten(TreeNode node, TreeNode prev) {
        if (node == null)
            return prev;
        prev = flatten(node.right, prev);
        prev = flatten(node.left, prev);
        node.right = prev;
        node.left = null;
        prev = node;
        return prev;
    }
}