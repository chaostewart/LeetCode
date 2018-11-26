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
    // recursive solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val)*(q.val - root.val) > 0) 
            return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);       
        return root;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // this is not just a binary tree...a BST has its left child smaller than it, and right child larger than it
        // here comes a genius's code...OMG..
        while((root.val - p.val) * (root.val - q.val) > 0)   // keep searching when p & q are on the same side of root, O(logn)
            root = root.val > p.val ? root.left : root.right;      
        return root;
    }
}
