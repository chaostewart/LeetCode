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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();   // Use Queue to do level order traversal
        queue.offer(root);
        while(!queue.isEmpty()) {        
            int levelSize = queue.size();    // levelSize is the number of nodes at this tree level
            List<Integer> sublist = new LinkedList<>();     // store nodes' values at this tree level
            for (int i = 0; i < levelSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);     // if their children exit, enqueue
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);   // deque the nodes at this level and store their values
            }
            res.add(sublist);
        }
        return res;        
    }
}