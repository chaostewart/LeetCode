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
That node can either be p's parent or the smallest node in p' right branch.
When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.
 
If it's p's parent node, there are two scenarios: 
1. p doesn't have right child, in this case, the recursion will eventually return null, so p's parent is the successor; 
2. p has right child, then the recursion will return the smallest node in the right sub tree, and that will be the answer.

If it's p's right child, there are two scenarios: 
2a. the right child has left sub tree, eventually the smallest node from the left sub tree will be the answer; 
2b. the right child has no left sub tree, the recursion will return null, then the right child (root) is our answer.
*/
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (p.val >= root.val)                  
            return inorderSuccessor(root.right, p);
        else {                                 
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;   
        }
    }
}
