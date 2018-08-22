/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
If the current (sub)tree contains both p and q, then the function result is their LCA. 
####### If only one of them is in that subtree, then the result is that one of them. ######
If neither are in that subtree, the result is null.
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)    // tree is empty OR reached a leaf's child OR found either p or q
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);     // recurse on the left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);   // recurse on the right subtree
        if (left != null && right != null)     // if both nodes are found, current root is LCA
            return root;
        return left != null ? left : right;   // if only one node is found in the tree, then that node is the LCA
    }
}
