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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {    
        if (t1 == null || t2 == null) 
            return t1 == null ? t2 : t1; 
        // must be the case where neither node is null
        TreeNode tsum = new TreeNode(t1.val + t2.val);  // need to initialize the value as sum
        tsum.left = mergeTrees(t1.left, t2.left);    // do it recursively on both children
        tsum.right = mergeTrees(t1.right, t2.right);

        return tsum;
    }
}
