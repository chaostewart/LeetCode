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
    List<Integer> ans = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return ans;
        ans.add(root.val);
        if (root.left == null && root.right == null) // the case where the tree has only one node
            return ans;
        getLeftBoundary(root.left);     // excluding the left-most node which is also a leaf
        getLeaves(root);                // including both left-most and right-most leaves
        getRightBoundary(root.right);   // excluding the right-most node
        return ans;
    }
    
    private void getLeftBoundary(TreeNode root) {
        // if original root's left child is null, or reached the left-most node, stop recursion
        if (root == null || (root.left == null && root.right == null)) return;    
        ans.add(root.val);    // Note: add value before recursion
        if (root.left != null) getLeftBoundary(root.left);   
        else getLeftBoundary(root.right);   // if left subtree is null, traverse right subtree
    }
    
    private void getRightBoundary(TreeNode root) {
        // if original root's right child is null, or reached the right-most node, stop recursion
        if (root == null || (root.left == null && root.right == null)) return;                
        if (root.right != null) getRightBoundary(root.right);   
        else getRightBoundary(root.left);  // if right subtree is null, traverse left subtree
        ans.add(root.val);    // Note: add value after recursion to get reversed nodes
    }
    
    private void getLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {    // reached leaves, add value, return
            ans.add(root.val);
            return;
        }
        if (root.left != null) getLeaves(root.left);     // traverse internal nodes from left to right
        if (root.right != null) getLeaves(root.right);       
    }
    
}