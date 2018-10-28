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
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev)
                return false;
            prev = root.val;
            root = root.right;           
        }
         return true;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // Using Stack to do an inorder traversal, note all nodes are touched from the smallest value to the largest
        if (root == null) return true;
        TreeNode prev = null, curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) { // if root is not a right child of leaf node OR not all nodes have been touched
            while (curr != null) {    // if root is not a right child of leaf node 
                stack.push(curr);     // push all left broundary of a subtree to the stack
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.val >= curr.val) return false;   // prev only equals null at initialization
            prev = curr;
            curr = curr.right;  // in the next round, a node will be compared to its right child
        }
        return true;
    }
}
