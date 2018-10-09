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
    public int minDiffInBST(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode curr = root, pre = null; 
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } 
            curr = stack.pop(); 
            if (pre != null) 
                ans = Math.min(ans, curr.val - pre.val); 
            pre = curr; 
            curr = curr.right; 
            
        }
        return ans;
    }
}