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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, root, new ArrayList<Integer>(), sum);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, TreeNode node, List<Integer> sublist, int target) {
        if (node == null)
            return;
        sublist.add(node.val);
        if (node.left == null && node.right == null && node.val == target)
            res.add(new ArrayList<>(sublist));
        else {
            backtrack(res, node.left, sublist, target - node.val);
            backtrack(res, node.right, sublist, target - node.val);        
        }
        sublist.remove(sublist.size() - 1);     
    }
}