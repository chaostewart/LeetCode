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
        if (t1 == null && t2 == null) return null; 
        TreeNode tsum = new TreeNode(0);  // need to initialize a value
        if (t1 != null && t2 != null){    // if both nodes are not null, sum the vals
            tsum.val = t1.val + t2.val;
            tsum.left = mergeTrees(t1.left, t2.left);    // do it recursively on both children
            tsum.right = mergeTrees(t1.right, t2.right);
        }
        else
            tsum = t1 == null ? t2 : t1;  // tsum copies the not null node
        return tsum;
    }
}

/* more concise version
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        
        return newNode;
    }
}
*/