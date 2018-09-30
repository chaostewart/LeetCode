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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {       
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            while (levelSize > 0) {
                TreeNode node = q.poll();
                levelList.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                levelSize--;
            }
            if (res.size() % 2 == 1)
                Collections.reverse(levelList);
            res.add(levelList);        
        }
        return res;
    }
    /* old version // with helper funtion and recursion
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        DFStraverse(root, res, 0);
        return res;
    }
    
    // recursive DFS traversal on the tree from left child to right child of each node
    private void DFStraverse(TreeNode curr, List<List<Integer>> res, int level) {
        if (curr == null)   // leaf case
            return;
        
        if (res.size() <= level) {     // create a inner list for each level of nodes
            List<Integer> newLevel = new LinkedList();
            res.add(newLevel);
        }
        
        List<Integer> currLevel = res.get(level);   // get the current level's inner list from outer list
        if (level % 2 == 0)                         // for even-number levels, traversal is from left to right
            currLevel.add(curr.val);                // so add new node value to the end of inner list
        else                                        // for odd-number levels, traversal is from right to left
            currLevel.add(0, curr.val);             // so add new node value to the front (index = 0) of inner list
        
        DFStraverse(curr.left, res, level + 1);     // traverse from left to right
        DFStraverse(curr.right, res, level + 1);
        */
    }
}
