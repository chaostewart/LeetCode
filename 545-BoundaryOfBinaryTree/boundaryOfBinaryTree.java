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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>(1000);
        if (root == null) return ans;
        ans.add(root.val);
        if (root.left == null && root.right == null) // the case where the tree has only one node
            return ans;
        getLeftBoundary(root.left, ans);     // excluding the left-most node which is also a leaf
        getLeaves(root, ans);                // including both left-most and right-most leaves
        getRightBoundary(root.right, ans);   // excluding the right-most node
        return ans;
    }
    
    private void getLeftBoundary(TreeNode root, List<Integer> ans) {
        // if original root's left child is null, or reached the left-most node, stop recursion
        if (root == null || (root.left == null && root.right == null)) return;    
        ans.add(root.val);    // Note: add value before recursion
        getLeftBoundary(root.left == null ? root.right : root.left, res);// if left subtree is null, traverse right subtree
    }
    
    private void getRightBoundary(TreeNode root, List<Integer> ans) {
        // if original root's right child is null, or reached the right-most node, stop recursion
        if (root == null || (root.left == null && root.right == null)) return;                
        getRightBoundary(root.right == null ? root.left : root.right, res);// if right subtree is null, traverse left subtree
        ans.add(root.val);    // Note: add value after recursion to get reversed nodes
    }
    
    private void getLeaves(TreeNode root, List<Integer> ans) {
        if (root.left == null && root.right == null) {    // reached leaves, add value, return
            ans.add(root.val);
            return;
        }
        if (root.left != null) getLeaves(root.left, ans);     // traverse internal nodes from left to right
        if (root.right != null) getLeaves(root.right, ans);       
    }
    
}
