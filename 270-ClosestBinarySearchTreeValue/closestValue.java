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
    public int closestValue(TreeNode root, double target) {
        int curr = root.val;
        TreeNode kid = target < curr ? root.left : root.right;
        if (kid == null) return curr;
        int next = closestValue(kid, target);
        return Math.abs(curr - target) < Math.abs(next - target) ? curr : next;
    }
}