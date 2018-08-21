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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postOrder(root, new HashMap<String, Integer>(), res);
        return res;
    }
    
    public String postOrder(TreeNode curr, Map<String, Integer> map, List<TreeNode> res) {
        // when reaching leaves, return null value
        if (curr == null) return "null";
        // though postorder is performed, tree serial is saved in preorder
        String serial = curr.val + "," + postOrder(curr.left, map, res) + "," + postOrder(curr.right, map, res);
        // save a new subtree or add count of an existing subtree
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        // if this subtree has occurred and hasn't added to result before, save to result
        if (map.get(serial) == 2) res.add(curr);
        return serial;
    }
}