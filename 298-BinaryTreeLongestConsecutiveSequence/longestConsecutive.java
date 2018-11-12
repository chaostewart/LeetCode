/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// newer version, easier to follow
class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        longestConsecutive(root, res);
        return res[0];
    }
    // private function returns the length of consecutive sequence starts from the input root node
    // final answer is stored/updated in res[0]
    private int longestConsecutive(TreeNode root, int[] res) {
        if (root == null) return 0;
        int ans = 1;
        int left = longestConsecutive(root.left, res);
        int right = longestConsecutive(root.right, res);
        if (left != 0 && root.left.val == root.val + 1)
            ans = Math.max(1+left, ans);
        if (right != 0 && root.right.val == root.val + 1)
            ans = Math.max(1+right, ans);
        res[0] = Math.max(ans, res[0]);
        return ans;
    }
}


class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(DFS(root.left, 1, root.val), DFS(root.right, 1, root.val));
    }
    
    private int DFS(TreeNode node, int count, int parentVal) {
        if (node == null) return count;
        count = (node.val - parentVal == 1) ? count + 1 : 1;
        int left = DFS(node.left, count, node.val);
        int right = DFS(node.right, count, node.val);
        return Math.max(count, Math.max(left, right));
    }
}

