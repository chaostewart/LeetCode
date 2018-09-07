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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if (left == null || right == null)
            return left == right;
        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}