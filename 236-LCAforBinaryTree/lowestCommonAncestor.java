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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // has to be recursive
        if (root == null || root == p || root == q)    // reached the leaves or found p or q
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);     // recurse on the left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);   // recurse on the right subtree
        if (left != null && right != null)     // if both children are not null, current root is LCA
            return root;
        return left != null ? left : right;   // return to the upper level
    }
}