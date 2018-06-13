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
    public boolean isValidBST(TreeNode root) {
        // Using Stack to do an inorder traversal, note all nodes are touched from the smallest value to the largest
        if (root == null) return true;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) { // if root is not a right child of leaf node or not all nodes have been touched
            while (root != null) {    // if root is not a right child of leaf node 
                stack.push(root);     // push all left broundary of a subtree to the stack
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) return false;   // prev only equals null at initialization
            prev = root;
            root = root.right;  // in the next round, a node will be compared to its right child
        }
        return true;
    }
}