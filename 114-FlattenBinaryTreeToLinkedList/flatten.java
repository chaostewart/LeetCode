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
    private TreeNode flatten(TreeNode node, TreeNode next) {
        if (node == null) return next;
        next = flatten(node.right, next);
        next = flatten(node.left, next);
        node.right = next;
        node.left = null;
        next = node;
        return next;       
    }
}
