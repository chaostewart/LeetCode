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
    public List<Integer> rightSideView(TreeNode root) {        
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        // BFS starts here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) ans.add(node.val);   // get the value of the rightmost node at each level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);       
            }
        }
        return ans;
    }
}
